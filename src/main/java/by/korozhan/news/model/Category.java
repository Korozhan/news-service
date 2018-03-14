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
    private Long id;
    private String displayName;
    @DBRef
    private List<News> news;

    public Category() {
    }

    public Category(Long id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public Category(Long id, String displayName, List<News> news) {
        this.id = id;
        this.displayName = displayName;
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
