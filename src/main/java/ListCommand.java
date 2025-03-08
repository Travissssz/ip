/**
 * Represents a command to list all tasks.
 */
public class ListCommand extends Command {
    /**
     * Executes the list command by printing all tasks in the task list.
     *
     * @param partsOfInput The input string split into parts (not used in this command).
     */
    @Override
    public void execute(String[] partsOfInput) {
        Ui.printTaskList();
    }
}