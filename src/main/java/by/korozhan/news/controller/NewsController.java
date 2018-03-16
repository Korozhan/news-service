package by.korozhan.news.controller;

import by.korozhan.news.model.News;
import by.korozhan.news.service.INewsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * Veronika Korozhan March 12, 2018.
 */
@RestController
@RequestMapping(value = "/api/news")
@Api(value = "/api/news", description = "News operations")
public class NewsController {

    private final INewsService newsService;

    @Autowired
    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    @ApiOperation(value = "View a list of available news", response = List.class)
    @GetMapping
    public List<News> getAllNews() {
        return newsService.findAll();
    }

    @ApiOperation(value = "Search the news with hexId", response = News.class)
    @GetMapping("/{hexId}")
    public News getNews(@PathVariable String hexId) {
        return newsService.findOne(hexId);
    }

    @ApiOperation(value = "Search the news by category name", response = List.class)
    @GetMapping("/category/{categoryName}")
    public List<News> getNewsByCategory(@PathVariable String categoryName) {
        return newsService.findByCategory(categoryName);
    }

    @ApiOperation(value = "Add news", response = News.class)
    @PostMapping
    public News saveNews(@RequestBody News news) {
        return newsService.save(news);
    }

    @ApiOperation(value = "Update news", response = News.class)
    @PutMapping
    public News updateNews(@RequestBody News news) {
        return newsService.update(news);
    }

    @ApiOperation(value = "Remove news")
    @DeleteMapping("/{hexId}")
    public void deleteNews(@PathVariable String hexId) {
        newsService.delete(hexId);
    }
}
