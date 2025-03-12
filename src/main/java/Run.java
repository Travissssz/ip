/**
 * Handles the initialization and running of the Pooh application.
 */
public class Run {

    /**
     * Initializes the application and starts the interaction loop.
     */
    public static void runPooh() {
        Ui.printWelcomeMessage();
        Pooh.taskList = Storage.loadTasks();
        Pooh.taskCounter = Pooh.taskList.size(); // Update task counter
        System.out.println("Loaded " + Pooh.taskCounter + " task(s) from file.");
        Parser.interactWithUser();
    }
}