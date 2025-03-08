/**
 * Represents a task with a start and end time.
 */
public class Event extends Task {
    public String eventStartTime;
    public String eventEndTime;

    /**
     * Constructs an Event task with a name, start time, and end time.
     *
     * @param taskName      The name of the task.
     * @param eventStartTime The start time of the event.
     * @param eventEndTime   The end time of the event.
     */
    public Event(String taskName, String eventStartTime, String eventEndTime) {
        super(taskName);
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
    }

    /**
     * Converts the task to a file-friendly format.
     *
     * @return A string representation of the task for saving to a file.
     */
    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + taskName + " | " + eventStartTime + " | " + eventEndTime;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A string describing the task and its event times.
     */
    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: " + eventStartTime + " to: " + eventEndTime + ")";
    }
}