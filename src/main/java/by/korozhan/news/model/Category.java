package by.korozhan.news.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Veronika Korozhan March 1, 2018.
 */
@ApiModel(description="All details about the category")
@Document
public class Category implements Serializable{
    @Id
    @ApiModelProperty(notes = "The database generated category id")
    private String id;
    @ApiModelProperty(notes = "Category display name")
    private String displayName;

    public Category() {
    }

    public Category(String displayName, List<News> news) {
        this.displayName = displayName;
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

}
