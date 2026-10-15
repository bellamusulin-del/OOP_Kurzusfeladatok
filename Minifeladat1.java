// Mini task 1: three classes implement the same ContentSource interface.
// RssContentSource returns demo data (the real download comes later).
// DatabaseContentSource asks the repository for the stored news.
// MockContentSource returns fixed test data without network or database.

public interface ContentSource {
    List<News> load();
}

public class RssContentSource implements ContentSource {

    private final String feedUrl;

    public RssContentSource(String feedUrl) {
        this.feedUrl = feedUrl;
    }

    @Override
    public List<News> load() {
        List<News> loadedNews = new ArrayList<>();
        News demoNews = new News("RSS demo news", "Loaded from the feed", "rss", feedUrl);
        loadedNews.add(demoNews);
        return loadedNews;
    }
}

public class DatabaseContentSource implements ContentSource {

    private final NewsRepository newsRepository;

    public DatabaseContentSource(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> load() {
        List<News> storedNews = newsRepository.findAll();
        return storedNews;
    }
}

public class MockContentSource implements ContentSource {

    @Override
    public List<News> load() {
        List<News> fixedNews = new ArrayList<>();
        News firstNews = new News("Test Title 1", "Test Desc 1", "mock", "http://test.local/1");
        News secondNews = new News("Test Title 2", "Test Desc 2", "mock", "http://test.local/2");
        fixedNews.add(firstNews);
        fixedNews.add(secondNews);
        return fixedNews;
    }
}
