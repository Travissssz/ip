import java.util.Scanner;

public class Parser {

    // Main loop for interacting with the user.
    public static void interactWithUser() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String line = in.nextLine().trim().toLowerCase(); // Read and clean up input
                if (line.isEmpty()) {
                    throw new InvalidCommandException("Please enter a command");
                }
                String[] partsOfInput = line.split(" ", 2);
                String command = partsOfInput[0];

                Command cmd = getCommand(command);
                cmd.execute(partsOfInput);

            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static Command getCommand(String command) throws InvalidCommandException {
        switch (command) {
        case "bye":
            return new ByeCommand();
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(true); // Mark task
        case "unmark":
            return new MarkCommand(false); // Unmark task
        case "todo":
            return new TodoCommand();
        case "deadline":
            return new DeadlineCommand();
        case "event":
            return new EventCommand();
        case "delete":
            return new DeleteCommand();
        default:
            throw new InvalidCommandException("Please enter a valid command");
        }
    }
}