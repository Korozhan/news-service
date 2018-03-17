package by.korozhan.news.controller;

import by.korozhan.news.dto.CategoryDTO;
import by.korozhan.news.model.Category;
import by.korozhan.news.service.ICategoryService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Veronika Korozhan March 12, 2018.
 */
@RestController
@RequestMapping(value = "/api/categories")
@Api(value = "/api/categories", description = "Category operations")
public class CategoryController {
    private final ModelMapper modelMapper;
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @ApiOperation(value = "View a list of available categories", response = List.class)
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.findAll().stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Search the category with hexId", response = CategoryDTO.class)
    @GetMapping("/{hexId}")
    public CategoryDTO getCategory(@PathVariable String hexId) {
        return modelMapper.map(categoryService.findOne(hexId), CategoryDTO.class);
    }

    @ApiOperation(value = "Add category", response = CategoryDTO.class)
    @PostMapping
    public CategoryDTO saveCategory(@RequestBody CategoryDTO category) {
        return modelMapper.map(categoryService.save(
                modelMapper.map(category, Category.class)), CategoryDTO.class);
    }

    @ApiOperation(value = "Update category", response = CategoryDTO.class)
    @PutMapping
    public CategoryDTO updateCategory(@RequestBody CategoryDTO category) {
        return modelMapper.map(categoryService.update(
                modelMapper.map(category, Category.class)), CategoryDTO.class);
    }

    @ApiOperation(value = "Remove category")
    @DeleteMapping("/{hexId}")
    public void deleteCategory(@PathVariable String hexId) {
        categoryService.delete(hexId);
    }
}
