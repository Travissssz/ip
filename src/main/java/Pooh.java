import java.util.ArrayList;
import java.util.Scanner;

public class Pooh {

    // List of tasks
    public static ArrayList<Task> taskList = new ArrayList<>();
    public static int taskCounter = 0;

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
                    Ui.printByeMessage();
                    return;
                case "list":
                    Ui.printTaskList();
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
                    Storage.appendTask(newToDo);
                    Ui.printTaskAddedMessage(newToDo);
                    break;
                case "deadline":
                    if (partsOfInput.length < 2 || !partsOfInput[1].contains(" /by ")) {
                        throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [deadline TASKNAME /by DATE]");
                    }
                    String[] partsOfDeadline = partsOfInput[1].split(" /by ", 2);
                    Deadline newDeadline = new Deadline(partsOfDeadline[0], partsOfDeadline[1]);
                    taskList.add(newDeadline);
                    Storage.appendTask(newDeadline);
                    Ui.printTaskAddedMessage(newDeadline);
                    break;
                case "event":
                        if (partsOfInput.length < 2 || !partsOfInput[1].contains(" /from ") || !partsOfInput[1].contains(" /to ")) {
                            throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [event TASKNAME /from DATE /to DATE]");
                        }
                    String[] partsOfEvent = partsOfInput[1].split(" /from | /to ", 3);
                    Event newEvent = new Event(partsOfEvent[0], partsOfEvent[1], partsOfEvent[2]);
                    taskList.add(newEvent);
                    Storage.appendTask(newEvent);
                    Ui.printTaskAddedMessage(newEvent);
                    break;
                case "delete":
                    if(partsOfInput.length < 2) {
                        throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [delete TASKNUMBER]");
                    }try{
                    deleteTask(line);
                }catch (NumberFormatException e){
                    System.out.println("Error: Task number needs to be a numeric value!!!");
                }
                default:
                    throw new InvalidCommandException("Please enter a valid command");
                }
            }catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    public static void deleteTask(String line) {
        int index = Integer.parseInt(line.split(" ")[1]) - 1; // Extract task index
        // Validate task index
        if (index >= taskList.size() || index < 0) {
            System.out.println("Invalid index.");
        } else {
            String taskToDelete = taskList.get(index).toString();
            taskList.remove(taskList.get(index));
            Storage.saveAllTasks(taskList);
            Ui.printDeleteMessage(taskToDelete);
        }
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
                    Storage.saveAllTasks(taskList);
                    Ui.printLine();
                    System.out.printf("Nice! I've marked this task as done:%n%s%n", taskList.get(index));
                    Ui.printLine();
                } else {
                    taskList.get(index).setIsDone(false); // Unmark task
                    Storage.saveAllTasks(taskList);
                    Ui.printLine();
                    System.out.printf("OK, I've marked this task as not done yet:%n%s%n", taskList.get(index));
                    Ui.printLine();
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

    //Main method that starts the Pooh assistant.
    public static void main(String[] args) {
        Ui.printWelcomeMessage();
        taskList = Storage.loadTasks();
        taskCounter = taskList.size(); // Update task counter
        System.out.println("Loaded " + taskCounter + " task(s) from file.");
        interactWithUser();
    }

}
