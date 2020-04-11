package pl.kkowalewski.knightstour.exception.algorithm;

public class SolutionNotFoundException extends RuntimeException {

    /*------------------------ FIELDS REGION ------------------------*/

    /*------------------------ METHODS REGION ------------------------*/
    public SolutionNotFoundException() {
    }

    public SolutionNotFoundException(String message) {
        super(message);
    }

    public SolutionNotFoundException(Throwable cause) {
        super(cause);
    }
}
    