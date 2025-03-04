public class EventCommand extends Command {
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