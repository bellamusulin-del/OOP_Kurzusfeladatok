// Mini task 3: Event model with date parsing.
// Checked in the constructor: title, date text and location are required.
// Timestamp.valueOf throws IllegalArgumentException when the format is wrong,
// we catch it and throw a new one with a clear message.
// The date must be in the future.

public class Event {

    private final String title;
    private final String description;
    private final String language;
    private final Timestamp eventDateTime;
    private final String location;

    public Event(String title, String description, String language,
                 String eventDateText, String location) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (eventDateText == null || eventDateText.isBlank()) {
            throw new IllegalArgumentException("Event date is required");
        }

        Timestamp parsedDateTime;
        try {
            parsedDateTime = Timestamp.valueOf(eventDateText);
        } catch (IllegalArgumentException parseProblem) {
            throw new IllegalArgumentException(
                    "Wrong date format: " + eventDateText + ". Expected: yyyy-MM-dd HH:mm:ss");
        }

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        if (!parsedDateTime.after(currentTime)) {
            throw new IllegalArgumentException("Event date must be in the future");
        }
        if (location == null || location.isBlank()) {
            throw new IllegalArgumentException("Location is required");
        }

        this.title = title;
        this.description = description;
        this.language = language;
        this.eventDateTime = parsedDateTime;
        this.location = location;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLanguage() { return language; }
    public Timestamp getEventDateTime() { return eventDateTime; }
    public String getLocation() { return location; }
}
