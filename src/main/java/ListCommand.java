public class ListCommand extends Command {
    @Override
    public void execute(String[] partsOfInput) {
        Ui.printTaskList();
    }
}