package exceptions;

public class InsufficientSeatsException extends Exception {
    public InsufficientSeatsException(String msg) {
        super(msg);
    }
}