package by.korozhan.news.service;

import by.korozhan.news.model.News;

import java.util.List;
import java.util.Optional;

/**
 * Veronika Korozhan March 11, 2018.
 */
public interface INewsService {

    News save(News news);

    void delete(Integer id);

    List<News> findAll();

    Optional<News> findOne(Integer id);

    boolean exists(Integer id);

    long count();

    List<News> findByTiltle(String title);
}
