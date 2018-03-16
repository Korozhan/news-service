package by.korozhan.news.repository;

import by.korozhan.news.config.AppConfig;
import by.korozhan.news.config.MongoConfig;
import by.korozhan.news.model.Category;
import by.korozhan.news.model.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

/**
 * Veronika Korozhan March 11, 2018.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfig.class, MongoConfig.class})
public class NewsRepositoryTest {
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    private News testNews;
    private Category testCategory;

    @Before
    public void setUp() throws Exception {
        testCategory = categoryRepository.save(new Category("test category"));
        testNews = newsRepository.save(new News(new Date(), "test title", "test body", testCategory));
    }

    @After
    public void tearDown() throws Exception {
        newsRepository.deleteAll();
        categoryRepository.deleteAll();
    }

    @Test
    public void findByTitle() throws Exception {
        List<News> news = newsRepository.findByTitle("test title");
        assertEquals(news.size(), 1);
        news.forEach(singleNews -> {
            assertEquals(singleNews.getTitle(), testNews.getTitle());
        });
    }

    @Test
    public void findByCategory() throws Exception {
        List<News> news = newsRepository.findByCategory(testCategory);
        assertEquals(news.size(), 1);
        news.forEach(singleNews -> {
            assertEquals(singleNews.getCategory().getDisplayName(), testCategory.getDisplayName());
        });
    }

}