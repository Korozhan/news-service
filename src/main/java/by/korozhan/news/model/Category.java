package by.korozhan.news.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Veronika Korozhan March 1, 2018.
 */
@Document
public class Category implements Serializable{
    @Id
    private String id;
    private String displayName;
    @DBRef
    private List<News> news;

    public Category() {
    }

    public Category(String displayName, List<News> news) {
        this.displayName = displayName;
        this.news = news;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
