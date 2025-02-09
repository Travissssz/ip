// Represents a Task with a name and completion status
public class Task {
    // Instance variables for task name and completion status
    private String taskName;
    private boolean isDone;

    // Constructor to create a Task with a specified name
    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false; // By default, task is not done
    }

    // Gets the task's name
    public String getTaskName() {
        return taskName;
    }

    // Sets the task's name
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    // Gets the task's completion status
    public boolean isDone() {
        return isDone;
    }

    // Sets the task's completion status
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    // Marks the task as done
    public void markAsDone() {
        this.isDone = true;
    }

    // Returns the status of the task as a string
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // Returns "X" if done, otherwise a space
    }

    // Returns the string representation of the task
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + taskName;
    }
}
