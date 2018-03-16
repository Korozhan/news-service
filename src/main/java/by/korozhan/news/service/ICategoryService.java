package by.korozhan.news.service;

import by.korozhan.news.model.Category;

import java.util.List;

/**
 * Veronika Korozhan March 11, 2018.
 */
public interface ICategoryService {

    List<Category> findAll();

    Category findOne(String hexId);

    Category findByName(String displayName);

    Category save(Category news);

    Category update(Category news);

    void delete(String hexId);

    void deleteAll();

    boolean exists(String hexId);
}
