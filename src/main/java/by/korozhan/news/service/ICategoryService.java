package by.korozhan.news.service;

import by.korozhan.news.model.Category;

import java.util.List;
import java.util.Optional;

/**
 * Veronika Korozhan March 11, 2018.
 */
public interface ICategoryService {
    Category save(Category news);

    void delete(Integer id);

    List<Category> findAll();

    Optional<Category> findOne(Integer id);

    boolean exists(Integer id);

    long count();

    List<Category> findByName(String displayName);
}
