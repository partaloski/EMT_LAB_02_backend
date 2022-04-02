package mk.finki.ukim.emt_lab_02.repository;

import mk.finki.ukim.emt_lab_02.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
    List<Country> findAllByContinent(String continent);
}
