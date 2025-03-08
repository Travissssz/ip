/**
 * Represents an exception thrown when an invalid command is entered.
 */
public class InvalidCommandException extends Exception {
    /**
     * Constructs an InvalidCommandException with the specified error message.
     *
     * @param message The error message.
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}