package by.korozhan.news.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Veronika Korozhan March 17, 2018.
 */
@ApiModel(description="All details about the news")
public class NewsDTO {
    @ApiModelProperty(notes = "The database generated news id")
    private String id;
    @ApiModelProperty(notes = "News publication date")
    private Date publicDate;
    @ApiModelProperty(notes = "The title of the news")
    private String title;
    @ApiModelProperty(notes = "The body of the news")
    private String body;
    @ApiModelProperty(notes = "The category of the news")
    private CategoryDTO category;

    public NewsDTO() {
    }

    public NewsDTO(Date publicDate, String title, String body, CategoryDTO category) {
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
