// Mini task 2: News class extended with author, publisher, language and coverImage.
// Checked in the constructor: title, source and url are required,
// and the url must start with http:// or https://.
// Author, publisher, language and coverImage are optional.
// There are only getters, no setters.

public class News {

    private final String title;
    private final String description;
    private final String source;
    private final String url;
    private final String author;
    private final String publisher;
    private final String language;
    private final String coverImage;

    public News(String title, String description, String source, String url,
                String author, String publisher, String language, String coverImage) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (source == null || source.isBlank()) {
            throw new IllegalArgumentException("Source is required");
        }
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("URL is required");
        }
        boolean startsWithHttp = url.startsWith("http://");
        boolean startsWithHttps = url.startsWith("https://");
        if (!startsWithHttp && !startsWithHttps) {
            throw new IllegalArgumentException("URL must start with http:// or https://");
        }
        this.title = title;
        this.description = description;
        this.source = source;
        this.url = url;
        this.author = author;
        this.publisher = publisher;
        this.language = language;
        this.coverImage = coverImage;
    }

    public News(String title, String description, String source, String url) {
        this(title, description, source, url, null, null, "hu", null);
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getSource() { return source; }
    public String getUrl() { return url; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public String getLanguage() { return language; }
    public String getCoverImage() { return coverImage; }
}
