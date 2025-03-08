/**
 * Handles user interface interactions, such as printing messages.
 */
public class Ui {

    /**
     * Prints a line to separate sections in the output.
     */
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Prints a goodbye message.
     */
    public static void printByeMessage() {
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    /**
     * Prints all tasks in the list.
     */
    public static void printTaskList() {
        printLine();
        if (Pooh.taskList.isEmpty()) {
            System.out.println("No tasks in the list yet.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < Pooh.taskList.size(); i++) {
                System.out.println((i + 1) + ". " + Pooh.taskList.get(i));
            }
        }
        printLine();
    }

    /**
     * Prints a welcome message.
     */
    public static void printWelcomeMessage() {
        printLine();
        System.out.println("Hello! I'm Pooh, your personal assistant.");
        System.out.println("What can I do for you today, sir?");
        printLine();
    }
}