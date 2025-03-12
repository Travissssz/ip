/**
 * Represents a command to add a to-do task.
 */
public class TodoCommand extends Command {
    /**
     * Executes the todo command by parsing the input and adding a new to-do task.
     *
     * @param partsOfInput The input string split into parts.
     * @throws MissingTaskDescriptionException If the task description is missing.
     */
    @Override
    public void execute(String[] partsOfInput) throws Exception {
        if (partsOfInput.length < 2) {
            throw new MissingTaskDescriptionException("Please enter a proper todo task description");
        }
        ToDo newToDo = new ToDo(partsOfInput[1]);
        Pooh.taskList.add(newToDo);
        Storage.appendTask(newToDo);
        Task.printTaskAddedMessage(newToDo);
    }
}