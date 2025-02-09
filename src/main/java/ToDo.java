public class ToDo extends Task{

    //Constructor to create a to-do
    public ToDo(String taskName) {
        super(taskName);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
