public class Task {
    protected String taskName;
    protected Boolean isDone;

    public Task(String taskName, Boolean isDone) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String statusOfTask() {
        if (isDone) {
            return "X";
        }
        return " ";
    }

    public String toString() {
        return "[" + statusOfTask() + "] " + taskName;
    }
}
