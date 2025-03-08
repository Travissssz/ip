/**
 * Represents a command to add an event task.
 */
public class EventCommand extends Command {
    /**
     * Executes the event command by parsing the input and adding a new event task.
     *
     * @param partsOfInput The input string split into parts.
     * @throws MissingTaskDescriptionException If the input format is invalid.
     */
    @Override
    public void execute(String[] partsOfInput) throws Exception {
        if (partsOfInput.length < 2 || !partsOfInput[1].contains(" /from ") || !partsOfInput[1].contains(" /to ")) {
            throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [event TASKNAME /from DATE /to DATE]");
        }
        String[] partsOfEvent = partsOfInput[1].split(" /from | /to ", 3);
        Event newEvent = new Event(partsOfEvent[0], partsOfEvent[1], partsOfEvent[2]);
        Pooh.taskList.add(newEvent);
        Storage.appendTask(newEvent);
        Task.printTaskAddedMessage(newEvent);
    }
}