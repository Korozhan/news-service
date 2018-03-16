package by.korozhan.news.model;

import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Veronika Korozhan March 1, 2018.
 */
@ApiModel(description="All details about the news")
@Document
public class News implements Serializable{
    @Id
    @ApiModelProperty(notes = "The database generated news id")
    private String id;
    @ApiModelProperty(notes = "News publication date")
    private Date publicDate;
    @ApiModelProperty(notes = "The title of the news")
    private String title;
    @ApiModelProperty(notes = "The body of the news")
    private String body;
    @ApiModelProperty(notes = "The category of the news")
    private Category category;

    public News() {
    }

    public News(Date publicDate, String title, String body, Category category) {
        this.publicDate = publicDate;
        this.title = title;
        this.body = body;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
