/**
 * Represents a task with a deadline.
 */
public class Deadline extends Task {
    private String deadline;

    /**
     * Constructs a Deadline task with a name and deadline.
     *
     * @param taskName The name of the task.
     * @param deadline The deadline of the task.
     */
    public Deadline(String taskName, String deadline) {
        super(taskName);
        if (Parser.isDateValid(deadline)) {
            deadline = Parser.formatDate(deadline);
            this.deadline = deadline;
        } else {
            this.deadline = deadline;
        }
    }

    /**
     * Converts the task to a file-friendly format.
     *
     * @return A string representation of the task for saving to a file.
     */
    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + taskName + " | " + deadline;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A string describing the task and its deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}