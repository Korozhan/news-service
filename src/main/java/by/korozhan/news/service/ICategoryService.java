package by.korozhan.news.service;

import by.korozhan.news.model.Category;

import java.util.List;

/**
 * Veronika Korozhan March 11, 2018.
 */
public interface ICategoryService {
    Category save(Category news);

    void delete(Integer id);

    List<Category> findAll();

    Category findOne(Integer id);

    boolean exists(Integer id);

    long count();

    List<Category> findByName(String displayName);
}
