package by.korozhan.news.repository;

import by.korozhan.news.model.Category;
import org.springframework.stereotype.Repository;

/**
 * Veronika Korozhan March 11, 2018.
 */
@Repository
public interface CategoryRepository extends GenericRepository<Category, String> {

    Category findByDisplayName(String displayName);
}
