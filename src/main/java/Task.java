// Represents a Task with a name and completion status
public abstract class Task {
    // Instance variables for task name and completion status
    protected String taskName;
    protected boolean isDone;

    // Constructor to create a Task with a specified name
    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false; // By default, task is not done
    }

    public static void deleteTask(String line) {
        int index = Integer.parseInt(line.split(" ")[1]) - 1; // Extract task index
        // Validate task index
        if (index >= Pooh.taskList.size() || index < 0) {
            System.out.println("Invalid index.");
        } else {
            String taskToDelete = Pooh.taskList.get(index).toString();
            Pooh.taskList.remove(Pooh.taskList.get(index));
            Storage.saveAllTasks(Pooh.taskList);
            Ui.printDeleteMessage(taskToDelete);
        }
    }

    //Marks the task as done or not done.
    public static void markTask(String line, boolean mark) {
        try {
            int index = Integer.parseInt(line.split(" ")[1]) - 1; // Extract task index

            // Validate task index
            if (index >= Pooh.taskList.size() || index < 0) {
                System.out.println("Invalid index.");
            } else {
                if (mark) {
                    Pooh.taskList.get(index).markAsDone(); // Mark task as done
                    Storage.saveAllTasks(Pooh.taskList);
                    Ui.printLine();
                    System.out.printf("Nice! I've marked this task as done:%n%s%n", Pooh.taskList.get(index));
                    Ui.printLine();
                } else {
                    Pooh.taskList.get(index).setIsDone(false); // Unmark task
                    Storage.saveAllTasks(Pooh.taskList);
                    Ui.printLine();
                    System.out.printf("OK, I've marked this task as not done yet:%n%s%n", Pooh.taskList.get(index));
                    Ui.printLine();
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Error: Task number needs to be a numeric value!!!");
        }
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

    public abstract String toFileFormat();

    // Returns the string representation of the task
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + taskName;
    }
}
