package by.korozhan.news.repository;

import by.korozhan.news.config.AppConfig;
import by.korozhan.news.config.MongoConfig;
import by.korozhan.news.model.News;
import by.korozhan.news.util.DateUtil;
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

    private News testNews;

    @Before
    public void setUp() throws Exception {
        testNews = newsRepository.save(new News(new Date(), "test title", "test body"));
    }

    @After
    public void tearDown() throws Exception {
        newsRepository.deleteAll();
    }

    @Test
    public void findByTitle() throws Exception {
        List<News> news = newsRepository.findByTitle("test title");
        assertEquals(news.size(), 1);
        assertEquals(news.get(0), testNews);
    }

}