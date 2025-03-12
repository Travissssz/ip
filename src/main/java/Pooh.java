import java.util.ArrayList;

/**
 * Represents the main class for the Pooh task management application.
 */
public class Pooh {

    // List of tasks
    public static ArrayList<Task> taskList = new ArrayList<>();
    public static int taskCounter = 0;

    /**
     * Main method that starts the Pooh assistant.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Run.runPooh();
    }
}
