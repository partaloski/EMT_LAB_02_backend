package mk.finki.ukim.emt_lab_02.repository;

import mk.finki.ukim.emt_lab_02.model.Author;
import mk.finki.ukim.emt_lab_02.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);
    List<Book> findAllByAuthor(Author author);
}
