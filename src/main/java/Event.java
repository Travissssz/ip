public class Event extends Task{
    public String eventStartTime;
    public String eventEndTime;

    public Event(String taskName, String eventStartTime, String eventEndTime ) {
        super(taskName);
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
    }

    public String toString() {
        return "[E] " + super.toString() + " (from: " + eventStartTime + " to: " + eventEndTime + ")";
    }
}
