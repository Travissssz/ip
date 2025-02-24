public class Deadline extends Task {
    private String deadline;

    public Deadline(String taskName, String deadline) {
        super(taskName);
        this.deadline = deadline;
    }

    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + taskName + " | " + deadline;
    }

    public String toString() {
        return "[D] " + super.toString() + " (by: " + deadline + ")";
    }
}
