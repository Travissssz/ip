import java.util.Scanner;

public class Pooh {

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

            lineBetweenText();
            System.out.println("    " + line);
            lineBetweenText();// Print user input
        }
    }

    public static void main(String[] args) {
        lineBetweenText();
        System.out.println("Hello! I'm Pooh, your own personal assistant");
        System.out.println("What can I do for you today sir?");
        lineBetweenText();

        Echo();
    }
}
