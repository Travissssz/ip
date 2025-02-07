public class Deadline extends Task {
    private String deadline;

    public Deadline(String taskName, String deadline) {
        super(taskName);
        this.deadline = deadline;
    }

    public String toString() {
        return "[D] " + super.toString() + " (by: " + deadline + ")";
    }
}
