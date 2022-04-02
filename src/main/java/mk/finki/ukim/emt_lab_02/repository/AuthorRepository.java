package mk.finki.ukim.emt_lab_02.repository;

import mk.finki.ukim.emt_lab_02.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameAndSurname(String name, String surname);
}
