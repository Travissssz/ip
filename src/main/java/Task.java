public abstract class Task {
    protected String taskName;
    protected boolean isDone;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false; // By default, task is not done
    }

    public static void printDeleteMessage(String Task) {
        Ui.printLine();
        System.out.println("I've removed this task:");
        System.out.println(Task);
        System.out.println("Now you have " + Pooh.taskList.size() + " tasks in the list");
        Ui.printLine();
    }

    public static void printTaskAddedMessage(Task task){
        Ui.printLine();
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + Pooh.taskList.size() + " tasks in the list");
        Ui.printLine();
    }

    // Marks the task as done or not done
    public void markTask(boolean mark) {
        if (mark) {
            this.markAsDone(); // Mark task as done
        } else {
            this.setIsDone(false); // Unmark task
        }
        Storage.saveAllTasks(Pooh.taskList); // Save the updated task list
    }

    // Marks the task as done
    public void markAsDone() {
        this.isDone = true;
    }

    public String getDescription() {
        return taskName;
    }

    // Sets the task's completion status
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    // Returns the status of the task as a string
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // Returns "X" if done, otherwise a space
    }

    public abstract String toFileFormat();

    // Returns the string representation of the task
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + taskName;
    }
}