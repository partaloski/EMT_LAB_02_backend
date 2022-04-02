package mk.finki.ukim.emt_lab_02.service.impl;

import mk.finki.ukim.emt_lab_02.model.Author;
import mk.finki.ukim.emt_lab_02.model.Book;
import mk.finki.ukim.emt_lab_02.model.Category;
import mk.finki.ukim.emt_lab_02.model.dto.BookDto;
import mk.finki.ukim.emt_lab_02.model.dto.CategoryDto;
import mk.finki.ukim.emt_lab_02.model.exceptions.AuthorWithIdNotFound;
import mk.finki.ukim.emt_lab_02.model.exceptions.BookHasNoAvailableCopies;
import mk.finki.ukim.emt_lab_02.model.exceptions.BookWithIdNotFound;
import mk.finki.ukim.emt_lab_02.repository.AuthorRepository;
import mk.finki.ukim.emt_lab_02.repository.BookRepository;
import mk.finki.ukim.emt_lab_02.repository.CountryRepository;
import mk.finki.ukim.emt_lab_02.service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public List<Book> findByAuthor(Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new AuthorWithIdNotFound(authorId));
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> editBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookWithIdNotFound(id));
        book.setName(bookDto.getName());
        Author author = authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorWithIdNotFound(bookDto.getAuthor()));
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(Category.valueOf(bookDto.getCategory()));
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> saveBook(BookDto bookDto) {
        Book book = new Book();
        book.setName(bookDto.getName());
        Author author = authorRepository.findById(bookDto.getAuthor()).orElseThrow(() -> new AuthorWithIdNotFound(bookDto.getAuthor()));
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(Category.valueOf(bookDto.getCategory()));
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookWithIdNotFound(id));
        this.bookRepository.delete(book);
    }

    @Override
    public Integer decreaseAvailableCopiesForBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookWithIdNotFound(id));
        Integer availableCopies = book.getAvailableCopies();
        if(availableCopies <= 0)
            throw new BookHasNoAvailableCopies(id);
        availableCopies--;
        book.setAvailableCopies(availableCopies);
        bookRepository.save(book);
        return availableCopies;
    }

    @Override
    public List<CategoryDto> findAllByCategories() {
        List<Book> books = findAll();
        Map<String, Integer> booksByCategory = new HashMap<>();
        for(Category c: Category.values()){
            booksByCategory.putIfAbsent(c.name(), 0);
        }
        for(Book b: books){
            int count = booksByCategory.get(b.getCategory().name()) + 1;
            booksByCategory.put(b.getCategory().name(), count);
        }
        List<CategoryDto> booksByCategoryDTO = new ArrayList<>();
        for(String key: booksByCategory.keySet()){
            booksByCategoryDTO.add(new CategoryDto(key, booksByCategory.get(key)));
        }
        return booksByCategoryDTO;
    }
}
