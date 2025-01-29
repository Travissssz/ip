import java.util.Arrays;
import java.util.Scanner;

public class Pooh {

    //initialise a class-level array for user input
    public static String[] listOfItems = new String[0];

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

            lineBetweenText();
            System.out.println("added: " + line);
            addToList(line);
            lineBetweenText();// Print user input
        }
    } //continues echoing


    public static void addToList(String item){
        listOfItems = Arrays.copyOf(listOfItems, listOfItems.length + 1);
        listOfItems[listOfItems.length - 1] = item;
    } // add user input to list \

    public static void printList(){
        lineBetweenText();
        if(listOfItems.length == 0){
            System.out.println("List is empty");
        }
        else {
            for (int i = 0; i < listOfItems.length; i++) {
                System.out.println(i + 1 + ". " + listOfItems[i]);
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
