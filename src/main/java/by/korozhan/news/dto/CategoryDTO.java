package by.korozhan.news.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Veronika Korozhan March 17, 2018.
 */
@ApiModel(description="All details about the category")
public class CategoryDTO {
    @ApiModelProperty(notes = "The database generated category id")
    private String id;
    @ApiModelProperty(notes = "Category display name")
    private String displayName;

    public CategoryDTO() {
    }

    public CategoryDTO(String displayName) {
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
