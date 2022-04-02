package mk.finki.ukim.emt_lab_02.service;


import mk.finki.ukim.emt_lab_02.model.Book;
import mk.finki.ukim.emt_lab_02.model.Category;
import mk.finki.ukim.emt_lab_02.model.dto.BookDto;
import mk.finki.ukim.emt_lab_02.model.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

/**
 * Во рамки на апликацијата се чуваат следните податоци за
 * книгите: id (Long), name (String), category (enum), author (Author), availableCopies (Integer).
 *
 * Категоријата на книгата може да биде: NOVEL, THRILER, HISTORY, FANTASY, BIOGRAPHY, CLASSICS, DRAMA.
 *
 * За секој автор пак се чуваат податоците: id (Long), name (String), surname (String), country (Country).
 *
 * За секоја земја се чуваат податоците: id (Long), name (String), continent (String).
 *
 */

public interface BookService {
    List<Book> findAll();
    Optional<Book> findByName(String name);
    List<Book> findByAuthor(Long authorId);
    Optional<Book> findById(Long id);
    Optional<Book> editBook(Long id, BookDto bookDto);
    Optional<Book> saveBook(BookDto bookDto);
    void deleteById(Long id);
    Integer decreaseAvailableCopiesForBook(Long id);
    List<CategoryDto> findAllByCategories();
}
