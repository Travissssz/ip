public class Deadline extends Task {
    private String deadline;

    public Deadline(String taskName, String deadline) {
        super(taskName);
        if(Parser.isDateValid(deadline)) {
            deadline = Parser.formatDate(deadline);
            this.deadline = deadline;
        }else{
            this.deadline = deadline;
        }
    }

    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + taskName + " | " + deadline;
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + deadline + ")";
    }
}
