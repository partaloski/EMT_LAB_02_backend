package mk.finki.ukim.emt_lab_02.service.impl;

import mk.finki.ukim.emt_lab_02.model.Author;
import mk.finki.ukim.emt_lab_02.model.Country;
import mk.finki.ukim.emt_lab_02.model.exceptions.AuthorWithIdNotFound;
import mk.finki.ukim.emt_lab_02.repository.AuthorRepository;
import mk.finki.ukim.emt_lab_02.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> findByNameAndSurname(String name, String surname) {
        return authorRepository.findByNameAndSurname(name, surname);
    }

    @Override
    public Optional<Author> editAuthor(Long id, String name, String surname, Country country) {
        Author author = findById(id).orElseThrow(() -> new AuthorWithIdNotFound(id));
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> saveAuthor(String name, String surname, Country country) {
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
