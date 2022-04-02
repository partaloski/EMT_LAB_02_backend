package mk.finki.ukim.emt_lab_02.model.exceptions;

public class BookHasNoAvailableCopies extends RuntimeException{
    public BookHasNoAvailableCopies(Long id) {
        super("The book with ID {" + id + "} has no more copies left." );
    }
}
