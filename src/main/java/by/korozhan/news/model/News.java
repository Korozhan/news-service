package by.korozhan.news.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Veronika Korozhan March 1, 2018.
 */
@Document
public class News implements Serializable{
    @Id
    private Long id;
    private Date publicDate;
    private String title;
    private String body;

    public News() {
    }

    public News(Date publicDate, String title, String body) {
        this.publicDate = publicDate;
        this.title = title;
        this.body = body;
    }

    public News(Long id, Date publicDate, String title, String body) {
        this.id = id;
        this.publicDate = publicDate;
        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
