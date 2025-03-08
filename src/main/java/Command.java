/**
 * An abstract class representing a command that can be executed.
 */
public abstract class Command {
    /**
     * Executes the command.
     *
     * @param partsOfInput The input string split into parts.
     * @throws Exception If an error occurs during execution.
     */
    public abstract void execute(String[] partsOfInput) throws Exception;
}