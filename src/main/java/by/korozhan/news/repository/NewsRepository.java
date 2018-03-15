package by.korozhan.news.repository;

import by.korozhan.news.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Veronika Korozhan March 11, 2018.
 */
@Repository
public interface NewsRepository extends GenericRepository<News, String> {

    List<News> findByTitle(String title);
}
