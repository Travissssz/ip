import java.util.ArrayList;
import java.util.Scanner;

public class Pooh {

    //Creates a list of Task
    public static ArrayList<Task> taskList = new ArrayList<>();

    public static void lineBetweenText(){
        System.out.println("____________________________________________________________");
    } //Prints the Line between the texts

    public static void Echo() {
        Scanner in = new Scanner(System.in);

        while (true) {  // Loop runs until 'bye' is entered
            String line = in.nextLine().trim(); // Read input and remove extra spaces

            if (line.equalsIgnoreCase("bye")) {
                lineBetweenText();
                System.out.println(" Bye. Hope to see you again soon!");
                lineBetweenText();
                break;
            }

            if (line.equalsIgnoreCase("list")) {
                printList();
                continue;
            }

            if(line.startsWith("mark ")){
                markTask(line, true);
                continue;
            }

            if(line.startsWith("unmark ")){
                markTask(line, false);
                continue;
            }

            lineBetweenText();
            System.out.println("added: " + line);
            addToList(line);
            lineBetweenText();// Print user input
        }
    } //continues echoing

    public static void markTask(String line, boolean mark) {
        int index = Integer.parseInt(line.split(" ")[1]) - 1;
        //input invalid index
        if(index >= taskList.size() || index < 0) {
            System.out.println("Invalid index");
        }
        else{
            if(mark){
                taskList.get(index).markAsDone();
                lineBetweenText();
                System.out.printf("Nice! I've marked this task as done:%n%s%n",  taskList.get(index));
            }
            else{
                taskList.get(index).setIsDone(false);
                lineBetweenText();
                System.out.printf("OK, I've marked this task as not done yet:%n%s%n", taskList.get(index));
            }
        }
    }

    public static void addToList(String item){
        taskList.add(new Task(item, false));
    } // add user input to list \

    public static void printList(){
        lineBetweenText();
        if (taskList.isEmpty()) {
            System.out.println(" No tasks in the list yet.");
        } else {
            System.out.println(" Here are the tasks in your list:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println((i + 1) + "." + taskList.get(i));
            }
        }
        lineBetweenText();
    } //prints list


    public static void main(String[] args) {
        lineBetweenText();
        System.out.println("Hello! I'm Pooh, your own personal assistant");
        System.out.println("What can I do for you today sir?");
        lineBetweenText();

        Echo();
    }
}
