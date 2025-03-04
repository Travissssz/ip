public class ByeCommand extends Command {
    @Override
    public void execute(String[] partsOfInput) {
        Ui.printByeMessage();
        System.exit(0); // Exit the program
    }
}