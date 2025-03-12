import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


public class Parser {

    // Main loop for interacting with the user.
    public static void interactWithUser() {
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                String line = in.nextLine().trim().toLowerCase(); // Read and clean up input
                if (line.isEmpty()) {
                    throw new InvalidCommandException("Please enter a command");
                }
                String[] partsOfInput = line.split(" ", 2);
                String command = partsOfInput[0];

                Command cmd = getCommand(command);
                cmd.execute(partsOfInput);

            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static Command getCommand(String command) throws InvalidCommandException {
        switch (command) {
        case "bye":
            return new ByeCommand();
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(true); // Mark task
        case "unmark":
            return new MarkCommand(false); // Unmark task
        case "todo":
            return new TodoCommand();
        case "deadline":
            return new DeadlineCommand();
        case "event":
            return new EventCommand();
        case "delete":
            return new DeleteCommand();
        default:
            throw new InvalidCommandException("Please enter a valid command");
        }
    }

    public static String formatDate(String userDate){
        String outputFormat = "MMM dd yyyy"; // Desired output format

        // Try parsing the input string using flexible parsing
        LocalDate parsedDate = null;
        try {
            // Use DateTimeFormatter.ISO_DATE to handle common formats
            parsedDate = LocalDate.parse(userDate, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException e1) {
            try {
                // Try parsing with a more flexible formatter
                parsedDate = LocalDate.parse(userDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e2) {
                try {
                    // Try parsing with another common format
                    parsedDate = LocalDate.parse(userDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                } catch (DateTimeParseException e3) {
                    throw new UnableToParseDate("Unable to parse date. Please try dd/MM/yyyy");
                }
            }
        }

        // Format the parsed date into the desired output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat, Locale.ENGLISH);
        String reformattedStr = parsedDate.format(outputFormatter);
        return reformattedStr;

    }


    public static boolean isDateValid(String input) {

        List<String> dateFormats = Arrays.asList(
                "dd/MM/yyyy", // e.g., 31/12/2023
                "dd-MM-yyyy", // e.g., 31-12-2023
                "yyyy/MM/dd", // e.g., 2023/12/31
                "MM/dd/yyyy", // e.g., 12/31/2023
                "dd MMM yyyy", // e.g., 31 Dec 2023
                "dd MMMM yyyy"  // e.g., 31 December 2023
        );

        for (String format : dateFormats) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                sdf.setLenient(false); // Ensure strict parsing
                sdf.parse(input); // Try to parse the input
                return true; // If parsing succeeds, it's a valid date
            } catch (ParseException e) {
                // Continue to the next format if parsing fails
            }
        }
        return false; 
    }


}