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
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Veronika Korozhan March 11, 2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, MongoConfig.class})
public class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    private Category testCategory;

    @Before
    public void setUp() throws Exception {
        testCategory = categoryRepository.save(new Category("test display name", Arrays.asList(new News(new Date(), "test title", "test body"))));
    }

    @After
    public void tearDown() throws Exception {
        categoryRepository.deleteAll();
    }

    @Test
    public void findByDisplayName() throws Exception {
        List<Category> news = categoryRepository.findByDisplayName("test display name");
        assertEquals(news.size(), 1);
        assertEquals(news.get(0), testCategory);
    }

}