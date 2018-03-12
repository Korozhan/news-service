package by.korozhan.news.service;

import by.korozhan.news.model.News;

import java.util.List;

/**
 * Veronika Korozhan March 11, 2018.
 */
public interface INewsService {

    News save(News news);

    void delete(Integer id);

    List<News> findAll();

    News findOne(Integer id);

    boolean exists(Integer id);

    long count();

    List<News> findByTiltle(String title);
}
