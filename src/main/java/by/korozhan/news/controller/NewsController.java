package by.korozhan.news.controller;

import by.korozhan.news.dto.NewsDTO;
import by.korozhan.news.model.News;
import by.korozhan.news.service.INewsService;
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
@RequestMapping(value = "/api/news")
@Api(value = "/api/news", description = "News operations")
public class NewsController {
    private final ModelMapper modelMapper;
    private final INewsService newsService;

    @Autowired
    public NewsController(INewsService newsService, ModelMapper modelMapper) {
        this.newsService = newsService;
        this.modelMapper = modelMapper;
    }

    @ApiOperation(value = "View a list of available news", response = List.class)
    @GetMapping
    public List<NewsDTO> getAllNews() {
        return newsService.findAll().stream()
                .map(news -> modelMapper.map(news, NewsDTO.class))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Search the news with hexId", response = NewsDTO.class)
    @GetMapping("/{hexId}")
    public NewsDTO getNews(@PathVariable String hexId) {
        return modelMapper.map(newsService.findOne(hexId), NewsDTO.class);
    }

    @ApiOperation(value = "Search the news by category name", response = List.class)
    @GetMapping("/category/{categoryName}")
    public List<NewsDTO> getNewsByCategory(@PathVariable String categoryName) {
        return newsService.findByCategory(categoryName).stream()
                .map(news -> modelMapper.map(news, NewsDTO.class))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Add news", response = NewsDTO.class)
    @PostMapping
    public NewsDTO saveNews(@RequestBody NewsDTO news) {
        return modelMapper.map(newsService.save(
                modelMapper.map(news, News.class)), NewsDTO.class);
    }

    @ApiOperation(value = "Update news", response = News.class)
    @PutMapping
    public NewsDTO updateNews(@RequestBody NewsDTO news) {
        return modelMapper.map(newsService.update(
                modelMapper.map(news, News.class)), NewsDTO.class);
    }

    @ApiOperation(value = "Remove news")
    @DeleteMapping("/{hexId}")
    public void deleteNews(@PathVariable String hexId) {
        newsService.delete(hexId);
    }
}
