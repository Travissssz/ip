/**
 * Represents an exception thrown when a date cannot be parsed.
 */
public class UnableToParseDate extends RuntimeException {
    /**
     * Constructs an UnableToParseDate exception with the specified error message.
     *
     * @param message The error message.
     */
    public UnableToParseDate(String message) {
        super(message);
    }
}