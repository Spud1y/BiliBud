package exceptions;

/**
 * Custom exception that means they entered an invalid time
 */
public class InvalidTimeException extends Exception {
    public InvalidTimeException(String errorMessage) {
        super(errorMessage);
    }
}
