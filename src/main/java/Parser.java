import java.util.Scanner;

public class Parser {


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
                    Task.markTask(line, true);
                    break;
                case "unmark":
                    Task.markTask(line, false);
                    break;
                case "todo":
                    if (partsOfInput.length < 2) {
                        throw new MissingTaskDescriptionException("Please enter a proper list task description");
                    }
                    ToDo newToDo = new ToDo(partsOfInput[1]);
                    Pooh.taskList.add(newToDo);
                    Storage.appendTask(newToDo);
                    Ui.printTaskAddedMessage(newToDo);
                    break;
                case "deadline":
                    if (partsOfInput.length < 2 || !partsOfInput[1].contains(" /by ")) {
                        throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [deadline TASKNAME /by DATE]");
                    }
                    String[] partsOfDeadline = partsOfInput[1].split(" /by ", 2);
                    Deadline newDeadline = new Deadline(partsOfDeadline[0], partsOfDeadline[1]);
                    Pooh.taskList.add(newDeadline);
                    Storage.appendTask(newDeadline);
                    Ui.printTaskAddedMessage(newDeadline);
                    break;
                case "event":
                        if (partsOfInput.length < 2 || !partsOfInput[1].contains(" /from ") || !partsOfInput[1].contains(" /to ")) {
                            throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [event TASKNAME /from DATE /to DATE]");
                        }
                    String[] partsOfEvent = partsOfInput[1].split(" /from | /to ", 3);
                    Event newEvent = new Event(partsOfEvent[0], partsOfEvent[1], partsOfEvent[2]);
                    Pooh.taskList.add(newEvent);
                    Storage.appendTask(newEvent);
                    Ui.printTaskAddedMessage(newEvent);
                    break;
                case "delete":
                    if(partsOfInput.length < 2) {
                        throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [delete TASKNUMBER]");
                    }try{
                    Task.deleteTask(line);
                }catch (NumberFormatException e){
                    System.out.println("Error: Task number needs to be a numeric value!!!");
                }
                    break;
                default:
                    throw new InvalidCommandException("Please enter a valid command");
                }
            }catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
