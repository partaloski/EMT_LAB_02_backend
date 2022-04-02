package mk.finki.ukim.emt_lab_02.model.exceptions;

public class CountryWithIdNotFound extends RuntimeException{
    public CountryWithIdNotFound(Long id) {
        super("Country with ID {" + id + "} cannot be found.");
    }
}
