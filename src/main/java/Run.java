public class Run {

    public static void runPooh(){
        Ui.printWelcomeMessage();
        Pooh.taskList = Storage.loadTasks();
        Pooh.taskCounter = Pooh.taskList.size(); // Update task counter
        System.out.println("Loaded " + Pooh.taskCounter + " task(s) from file.");
        Parser.interactWithUser();
    }
}
