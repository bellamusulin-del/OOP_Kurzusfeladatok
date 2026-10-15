// Mini task 4: who updates the list and how the detail panel is notified.
// NewsListPanel only shows the list and tells the listener when a news is selected.
// NewsDetailPanel only shows one news.
// MainWindow connects the two panels and asks the service for the news.

public interface NewsSelectionListener {
    void newsSelected(News selectedNews);
}

public class NewsListPanel extends JPanel {

    private final DefaultListModel<String> titleListModel = new DefaultListModel<>();
    private final JList<String> titleList = new JList<>(titleListModel);
    private List<News> shownNews = new ArrayList<>();
    private NewsSelectionListener selectionListener;

    public NewsListPanel() {
        setLayout(new BorderLayout());
        add(new JScrollPane(titleList), BorderLayout.CENTER);

        titleList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (event.getValueIsAdjusting()) {
                    return;
                }
                int selectedIndex = titleList.getSelectedIndex();
                if (selectedIndex < 0 || selectionListener == null) {
                    return;
                }
                News selectedNews = shownNews.get(selectedIndex);
                selectionListener.newsSelected(selectedNews);
            }
        });
    }

    public void setSelectionListener(NewsSelectionListener selectionListener) {
        this.selectionListener = selectionListener;
    }

    public void showNews(List<News> newsToShow) {
        shownNews = newsToShow;
        titleListModel.clear();
        for (News oneNews : newsToShow) {
            titleListModel.addElement(oneNews.getTitle());
        }
    }
}

public class NewsDetailPanel extends JPanel {

    private final JLabel titleLabel = new JLabel();
    private final JTextArea descriptionArea = new JTextArea();
    private final JLabel sourceLabel = new JLabel();

    public NewsDetailPanel() {
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(new JScrollPane(descriptionArea), BorderLayout.CENTER);
        add(sourceLabel, BorderLayout.SOUTH);
    }

    public void showNews(News news) {
        titleLabel.setText(news.getTitle());
        descriptionArea.setText(news.getDescription());
        sourceLabel.setText(news.getSource() + " - " + news.getUrl());
    }
}

public class MainWindow extends JFrame implements NewsSelectionListener {

    private final NewsService newsService;
    private final NewsListPanel listPanel = new NewsListPanel();
    private final NewsDetailPanel detailPanel = new NewsDetailPanel();

    public MainWindow(NewsService newsService) {
        this.newsService = newsService;

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPanel, detailPanel);
        splitPane.setResizeWeight(0.33);
        add(splitPane);

        listPanel.setSelectionListener(this);
        setSize(900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void newsSelected(News selectedNews) {
        detailPanel.showNews(selectedNews);
    }

    public void reloadList() {
        List<News> allNews = newsService.getAllNews();
        listPanel.showNews(allNews);
    }
}
