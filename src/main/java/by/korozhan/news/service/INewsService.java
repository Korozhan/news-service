package by.korozhan.news.service;

import by.korozhan.news.model.News;

import java.util.List;

/**
 * Veronika Korozhan March 11, 2018.
 */
public interface INewsService {

    List<News> findAll();

    News findOne(String hexId);

    List<News> findByTitle(String title);

    News save(News news);

    News update(News news);

    void delete(String hexId);

    void deleteAll();

    boolean exists(String hexId);

    List<News> findByCategory(String categoryName);
}
