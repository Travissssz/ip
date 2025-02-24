import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Pooh {

    // List of tasks
    public static ArrayList<Task> taskList = new ArrayList<>();
    public static int taskCounter = 0;

    //Prints a line to separate sections in the output.
    public static void printLine() {
        System.out.println("____________________________________________________________");
    }

    //Main loop for interacting with the user.
    public static void interactWithUser() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String line = in.nextLine().trim().toLowerCase(); // Read and clean up input
                if(line.isEmpty()) {
                    throw new InvalidCommandException("Please enter a command");
                }
                String[] partsOfInput = line.split(" ", 2);
                String command = partsOfInput[0];
                switch (command) {
                case "bye":
                    printByeMessage();
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
                case "todo":
                    if (partsOfInput.length < 2) {
                        throw new MissingTaskDescriptionException("Please enter a proper list task description");
                    }
                    ToDo newToDo = new ToDo(partsOfInput[1]);
                    taskList.add(newToDo);
                    Filesave.appendTask(newToDo);
                    printToDoTaskMessage(newToDo);
                    break;
                case "deadline":
                    if (partsOfInput.length < 2 || !partsOfInput[1].contains(" /by ")) {
                        throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [deadline TASKNAME /by DATE]");
                    }
                    String[] partsOfDeadline = partsOfInput[1].split(" /by ", 2);
                    Deadline newDeadline = new Deadline(partsOfDeadline[0], partsOfDeadline[1]);
                    taskList.add(newDeadline);
                    Filesave.appendTask(newDeadline);
                    printDeadLineMessage(newDeadline);
                    break;
                case "event":
                        if (partsOfInput.length < 2 || !partsOfInput[1].contains(" /from ") || !partsOfInput[1].contains(" /to ")) {
                            throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [event TASKNAME /from DATE /to DATE]");
                        }
                    String[] partsOfEvent = partsOfInput[1].split(" /from | /to ", 3);
                    Event newEvent = new Event(partsOfEvent[0], partsOfEvent[1], partsOfEvent[2]);
                    taskList.add(newEvent);
                    Filesave.appendTask(newEvent);
                    printEventMessage(newEvent);
                    break;
           default:
                    throw new InvalidCommandException("Please enter a valid command");
                }
            }catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }



    public static void printEventMessage(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + taskList.size() + " tasks in the list");
    }

    public static void markEvent(Event event) {
        taskList.add(event);
        taskCounter++;
    }


    public static void printDeadLineMessage(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + taskList.size() + " tasks in the list");
    }

    public static void markDeadline(Deadline deadline) {
        taskList.add(deadline);
        taskCounter++;
    }

    public static void printToDoTaskMessage(Task task){
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + taskList.size() + " tasks in the list");
    }

    public static void markToDoTask(Task task){
        taskList.add(task);
        taskCounter++;
    }

    public static void printByeMessage(){
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    //Marks the task as done or not done.
    public static void markTask(String line, boolean mark) {
        try {
            int index = Integer.parseInt(line.split(" ")[1]) - 1; // Extract task index

            // Validate task index
            if (index >= taskList.size() || index < 0) {
                System.out.println("Invalid index.");
            } else {
                if (mark) {
                    taskList.get(index).markAsDone(); // Mark task as done
                    Filesave.saveAllTasks(taskList);
                    printLine();
                    System.out.printf("Nice! I've marked this task as done:%n%s%n", taskList.get(index));

                } else {
                    taskList.get(index).setIsDone(false); // Unmark task
                    Filesave.saveAllTasks(taskList);
                    printLine();
                    System.out.printf("OK, I've marked this task as not done yet:%n%s%n", taskList.get(index));
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Error: Task number needs to be a numeric value!!!");
        }
    }

    //Adds a new task to the task list.
    public static void addToTaskList(String taskName) {
        taskList.add(new ToDo(taskName)); // Add task to the list, mark as not done
        taskCounter++;
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

    //Prints welcome message
    public static void printWelcomeMessage(){
        printLine();
        System.out.println("Hello! I'm Pooh, your personal assistant.");
        System.out.println("What can I do for you today, sir?");
        printLine();
    }

    //Main method that starts the Pooh assistant.
    public static void main(String[] args) {
        printWelcomeMessage();
        taskList = Filesave.loadTasks();
        taskCounter = taskList.size(); // Update task counter
        System.out.println("Loaded " + taskCounter + " task(s) from file.");
        interactWithUser();
    }

}
