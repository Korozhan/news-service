package by.korozhan.news.controller;

import by.korozhan.news.model.Category;
import by.korozhan.news.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Veronika Korozhan March 12, 2018.
 */
@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{hexId}")
    public Category getCategory(@PathVariable String hexId) {
        return categoryService.findOne(hexId);
    }

    @PostMapping
    public Category saveCategory(@RequestBody Category news) {
        return categoryService.save(news);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category news) {
        return categoryService.update(news);
    }

    @DeleteMapping("/{hexId}")
    public void deleteCategory(@PathVariable String hexId) {
        categoryService.delete(hexId);
    }
}
