package by.korozhan.news.repository;

import by.korozhan.news.model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Veronika Korozhan March 11, 2018.
 */
@Repository
public interface CategoryRepository extends GenericRepository<Category, String> {

    List<Category> findByDisplayName(String displayName);
}
