package by.korozhan.news.controller;

import by.korozhan.news.model.Category;
import by.korozhan.news.service.ICategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * Veronika Korozhan March 12, 2018.
 */
@RestController
@RequestMapping(value = "/api/category")
@Api(value = "/api/category", description = "Category operations")
public class CategoryController {

    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "View a list of available categories", response = List.class)
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @ApiOperation(value = "Search the category with hexId", response = Category.class)
    @GetMapping("/{hexId}")
    public Category getCategory(@PathVariable String hexId) {
        return categoryService.findOne(hexId);
    }

    @ApiOperation(value = "Add category", response = Category.class)
    @PostMapping
    public Category saveCategory(@RequestBody Category news) {
        return categoryService.save(news);
    }

    @ApiOperation(value = "Update category", response = Category.class)
    @PutMapping
    public Category updateCategory(@RequestBody Category news) {
        return categoryService.update(news);
    }

    @ApiOperation(value = "Remove category")
    @DeleteMapping("/{hexId}")
    public void deleteCategory(@PathVariable String hexId) {
        categoryService.delete(hexId);
    }
}
