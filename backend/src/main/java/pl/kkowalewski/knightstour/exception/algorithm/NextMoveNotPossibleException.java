package pl.kkowalewski.knightstour.exception.algorithm;

public class NextMoveNotPossibleException extends Exception {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    public NextMoveNotPossibleException() {
    }

    public NextMoveNotPossibleException(String message) {
        super(message);
    }

    public NextMoveNotPossibleException(Throwable cause) {
        super(cause);
    }
}
    