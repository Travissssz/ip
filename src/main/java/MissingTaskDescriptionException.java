/**
 * Represents an exception thrown when a task description is missing.
 */
public class MissingTaskDescriptionException extends Exception {
    /**
     * Constructs a MissingTaskDescriptionException with the specified error message.
     *
     * @param message The error message.
     */
    public MissingTaskDescriptionException(String message) {
        super(message);
    }
}