/**
 * Represents a to-do task.
 */
public class ToDo extends Task {

    /**
     * Constructs a ToDo task with a name.
     *
     * @param taskName The name of the task.
     */
    public ToDo(String taskName) {
        super(taskName);
    }

    /**
     * Converts the task to a file-friendly format.
     *
     * @return A string representation of the task for saving to a file.
     */
    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + taskName;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A string describing the task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}