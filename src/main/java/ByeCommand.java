/**
 * Represents a command to exit the program.
 */
public class ByeCommand extends Command {
    /**
     * Executes the bye command by printing a goodbye message and exiting the program.
     *
     * @param partsOfInput The input string split into parts (not used in this command).
     */
    @Override
    public void execute(String[] partsOfInput) {
        Ui.printByeMessage();
        System.exit(0); // Exit the program
    }
}