/**
 * Represents a command to add a deadline task.
 */
public class DeadlineCommand extends Command {
    /**
     * Executes the deadline command by parsing the input and adding a new deadline task.
     *
     * @param partsOfInput The input string split into parts.
     * @throws MissingTaskDescriptionException If the input format is invalid.
     */
    @Override
    public void execute(String[] partsOfInput) throws Exception {
        if (partsOfInput.length < 2 || !partsOfInput[1].contains(" /by ")) {
            throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [deadline TASKNAME /by DATE]");
        }
        String[] partsOfDeadline = partsOfInput[1].split(" /by ", 2);
        Deadline newDeadline = new Deadline(partsOfDeadline[0], partsOfDeadline[1]);
        Pooh.taskList.add(newDeadline);
        Storage.appendTask(newDeadline);
        Task.printTaskAddedMessage(newDeadline);
    }
}