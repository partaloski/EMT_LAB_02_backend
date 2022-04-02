package mk.finki.ukim.emt_lab_02.model.exceptions;

public class AuthorWithIdNotFound extends RuntimeException{
    public AuthorWithIdNotFound(Long id) {
        super("The author with ID {" + id + "} cannot be found.");
    }
}
