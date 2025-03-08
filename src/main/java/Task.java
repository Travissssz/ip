/**
 * Represents a task with a name and completion status.
 */
public abstract class Task {
    protected String taskName;
    protected boolean isDone;

    /**
     * Constructs a Task with a name.
     *
     * @param taskName The name of the task.
     */
    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false; // By default, task is not done
    }

    /**
     * Prints a message after deleting a task.
     *
     * @param Task The task that was deleted.
     */
    public static void printDeleteMessage(String Task) {
        Ui.printLine();
        System.out.println("I've removed this task:");
        System.out.println(Task);
        System.out.println("Now you have " + Pooh.taskList.size() + " tasks in the list");
        Ui.printLine();
    }

    /**
     * Prints a message after adding a task.
     *
     * @param task The task that was added.
     */
    public static void printTaskAddedMessage(Task task) {
        Ui.printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + Pooh.taskList.size() + " tasks in the list");
        Ui.printLine();
    }

    /**
     * Marks the task as done or not done.
     *
     * @param mark True to mark the task as done, false to unmark it.
     */
    public void markTask(boolean mark) {
        if (mark) {
            this.markAsDone(); // Mark task as done
        } else {
            this.setIsDone(false); // Unmark task
        }
        Storage.saveAllTasks(Pooh.taskList); // Save the updated task list
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns the description of the task.
     *
     * @return The task's description.
     */
    public String getDescription() {
        return taskName;
    }

    /**
     * Sets the task's completion status.
     *
     * @param isDone True if the task is done, false otherwise.
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Returns the status of the task as a string.
     *
     * @return "X" if the task is done, otherwise a space.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // Returns "X" if done, otherwise a space
    }

    /**
     * Converts the task to a file-friendly format.
     *
     * @return A string representation of the task for saving to a file.
     */
    public abstract String toFileFormat();

    /**
     * Returns the string representation of the task.
     *
     * @return A string describing the task and its status.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + taskName;
    }
}