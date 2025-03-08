/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    /**
     * Executes the delete command by removing the specified task from the task list.
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
                Task taskToDelete = Pooh.taskList.get(index);
                Pooh.taskList.remove(index);
                Storage.saveAllTasks(Pooh.taskList); // Save the updated task list
                Task.printDeleteMessage(taskToDelete.toString());
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Task number needs to be a numeric value!!!");
        }
    }
}