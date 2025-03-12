/**
 * Represents a command to mark or unmark a task as done.
 */
public class MarkCommand extends Command {
    private boolean isMark;

    /**
     * Constructs a MarkCommand.
     *
     * @param isMark True to mark the task as done, false to unmark it.
     */
    public MarkCommand(boolean isMark) {
        this.isMark = isMark;
    }

    /**
     * Executes the mark/unmark command by updating the task's status.
     *
     * @param partsOfInput The input string split into parts.
     * @throws NumberFormatException If the task index is not a valid number.
     */
    @Override
    public void execute(String[] partsOfInput) throws Exception {
        try {
            int index = Integer.parseInt(partsOfInput[1]) - 1; // Extract task index

            // Validate task index
            if (index >= Pooh.taskList.size() || index < 0) {
                System.out.println("Invalid index.");
            } else {
                Task task = Pooh.taskList.get(index);
                task.markTask(isMark); // Mark or unmark the task
                Ui.printLine();
                if (isMark) {
                    System.out.printf("Nice! I've marked this task as done:%n%s%n", task);
                } else {
                    System.out.printf("OK, I've marked this task as not done yet:%n%s%n", task);
                }
                Ui.printLine();
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Task number needs to be a numeric value!!!");
        }
    }
}