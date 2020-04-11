package pl.kkowalewski.knightstour.exception;

public class BoardNotFoundException extends RuntimeException {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    public BoardNotFoundException() {
    }

    public BoardNotFoundException(String message) {
        super(message);
    }

    public BoardNotFoundException(Throwable cause) {
        super(cause);
    }
}
    