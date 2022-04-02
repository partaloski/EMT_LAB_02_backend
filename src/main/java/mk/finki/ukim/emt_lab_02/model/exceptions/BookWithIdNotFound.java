package mk.finki.ukim.emt_lab_02.model.exceptions;

public class BookWithIdNotFound extends RuntimeException{
    public BookWithIdNotFound(Long id) {
        super("The book with ID {" + id + "} cannot be found.");
    }
}
