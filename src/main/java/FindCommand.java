import java.util.ArrayList;

public class FindCommand extends Command {
    @Override
    public void execute(String[] partsOfInput) throws Exception {
        if (partsOfInput.length < 2) {
            throw new MissingTaskDescriptionException("Please enter in the proper format. For example, [find TASKNAME]");
        }

        String keyword = partsOfInput[1].toLowerCase();
        ArrayList<Task> matchingTasks = new ArrayList<>();

        // Search for tasks containing the keyword
        for (int i = 0; i < Pooh.taskList.size(); i++) {
            Task task = Pooh.taskList.get(i);
            if (task.getDescription().toLowerCase().contains(keyword)) {
                matchingTasks.add(task);
            }
        }

        // Print results
        if (matchingTasks.isEmpty()) {
            Ui.printLine();
            System.out.println("No matching tasks found.");
            Ui.printLine();
        } else {
            Ui.printLine();
            System.out.println("Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println((i + 1) + "." + matchingTasks.get(i));
            }
            Ui.printLine();
        }
    }
}
