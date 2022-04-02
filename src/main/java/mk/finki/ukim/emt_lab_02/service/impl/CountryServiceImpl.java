package mk.finki.ukim.emt_lab_02.service.impl;

import mk.finki.ukim.emt_lab_02.model.Country;
import mk.finki.ukim.emt_lab_02.model.exceptions.CountryWithIdNotFound;
import mk.finki.ukim.emt_lab_02.repository.CountryRepository;
import mk.finki.ukim.emt_lab_02.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findByName(String name) {
        return countryRepository.findByName(name);
    }

    @Override
    public List<Country> findByContinent(String continent) {
        return countryRepository.findAllByContinent(continent);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> saveCountry(String name, String continent) {
        Country country = new Country();
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public Optional<Country> editCountry(Long id, String name, String continent) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new CountryWithIdNotFound(id));
        country.setName(name);
        country.setContinent(continent);
        return Optional.of(countryRepository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
