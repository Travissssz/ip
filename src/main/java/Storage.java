import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles loading and saving tasks to a file.
 */
public class Storage {
    private static final String FILE_PATH = "save/saved.txt";

    /**
     * Loads tasks from the file.
     *
     * @return A list of tasks loaded from the file.
     */
    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(FILE_PATH);

        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs(); // Create folder if missing
                file.createNewFile(); // Create file if missing
                return tasks;
            }

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" \\| ");
                if (parts.length < 3) continue;

                String type = parts[0];
                boolean isDone = parts[1].equals("1");
                String name = parts[2];

                Task task = null;
                if (type.equals("T")) {
                    task = new ToDo(name);
                } else if (type.equals("D") && parts.length == 4) {
                    task = new Deadline(name, parts[3]);
                } else if (type.equals("E") && parts.length == 5) {
                    task = new Event(name, parts[3], parts[4]);
                }

                if (task != null) {
                    task.setIsDone(isDone);
                    tasks.add(task);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }

    /**
     * Appends a task to the file.
     *
     * @param task The task to append.
     */
    public static void appendTask(Task task) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true)) {
            fw.write(task.toFileFormat() + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error saving task: " + e.getMessage());
        }
    }

    /**
     * Saves all tasks to the file.
     *
     * @param tasks The list of tasks to save.
     */
    public static void saveAllTasks(ArrayList<Task> tasks) {
        try (FileWriter fw = new FileWriter(FILE_PATH, false)) { // Overwrite file
            for (Task task : tasks) {
                fw.write(task.toFileFormat() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}