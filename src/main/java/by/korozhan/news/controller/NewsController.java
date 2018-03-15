package by.korozhan.news.controller;

import by.korozhan.news.model.News;
import by.korozhan.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Veronika Korozhan March 12, 2018.
 */
@RestController
@RequestMapping(value = "/api/news")
public class NewsController {

    private final INewsService newsService;

    @Autowired
    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getAllNews() {
        return newsService.findAll();
    }

    @GetMapping("/{hexId}")
    public News getNews(@PathVariable String hexId) {
        return newsService.findOne(hexId);
    }

    @PostMapping
    public News saveNews(@RequestBody News news) {
        return newsService.save(news);
    }

    @PutMapping
    public News updateNews(@RequestBody News news) {
        return newsService.update(news);
    }

    @DeleteMapping("/{hexId}")
    public void deleteNews(@PathVariable String hexId) {
        newsService.delete(hexId);
    }
}
