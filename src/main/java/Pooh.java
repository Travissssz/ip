import java.util.ArrayList;

public class Pooh {

    // List of tasks
    public static ArrayList<Task> taskList = new ArrayList<>();
    public static int taskCounter = 0;

    //Main method that starts the Pooh assistant.
    public static void main(String[] args) {
        Ui.printWelcomeMessage();
        taskList = Storage.loadTasks();
        taskCounter = taskList.size(); // Update task counter
        System.out.println("Loaded " + taskCounter + " task(s) from file.");
        Parser.interactWithUser();
    }

}
