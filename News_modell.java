public class News {
private String title;
private String description;
private String source;
private String url;
public News(
String title,
String description,
String source,
String url) {
// Validate required fields before storing them
if (title == null || title.isBlank()) {
throw new IllegalArgumentException("Title is required");
}
this.title = title;
this.description = description;
this.source = source;
this.url = url;
}
public String getTitle() { return title; }
// Add remaining getters — no blind setters!
}
