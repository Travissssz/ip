public class TodoCommand extends Command {
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