import java.util.ArrayList;
import java.util.Scanner;

public class Pooh {

    // List of tasks
    public static ArrayList<Task> taskList = new ArrayList<>();

    //Prints a line to separate sections in the output.
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    //Main loop for interacting with the user.
    public static void echo() {
        Scanner in = new Scanner(System.in);

        while (true) {
            String line = in.nextLine().trim().toLowerCase(); // Read and clean up input

            String[] partsOfInput = line.split(" ",2);
            String command = partsOfInput[0];
            switch (command) {
                case "bye":
                printBye();
                return;
            case "list":
                printTaskList();
                break;
            case "mark":
                markTask(line, true);
                break;
            case "unmark":
                markTask(line, false);
                break;
            default:
                printLine();
                System.out.println("Added: " + line);
                addToTaskList(line); // Add new task
                printLine();
            }
        }
    }
    
    public static void printBye(){
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    //Marks the task as done or not done.
    public static void markTask(String line, boolean mark) {
        int index = Integer.parseInt(line.split(" ")[1]) - 1; // Extract task index

        // Validate task index
        if (index >= taskList.size() || index < 0) {
            System.out.println("Invalid index.");
        } else {
            if (mark) {
                taskList.get(index).markAsDone(); // Mark task as done
                printLine();
                System.out.printf("Nice! I've marked this task as done:%n%s%n", taskList.get(index));
            } else {
                taskList.get(index).setIsDone(false); // Unmark task
                printLine();
                System.out.printf("OK, I've marked this task as not done yet:%n%s%n", taskList.get(index));
            }
        }
    }

    //Adds a new task to the task list.
    public static void addToTaskList(String taskName) {
        taskList.add(new Task(taskName, false)); // Add task to the list, mark as not done
    }

    //Prints all tasks in the list.
    public static void printTaskList() {
        printLine();
        if (taskList.isEmpty()) {
            System.out.println("No tasks in the list yet.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + ". " + taskList.get(i));
            }
        }
        printLine();
    }

    //Main method that starts the Pooh assistant.
    public static void main(String[] args) {
        printLine();
        System.out.println("Hello! I'm Pooh, your personal assistant.");
        System.out.println("What can I do for you today, sir?");
        printLine();

        echo();
    }
}
