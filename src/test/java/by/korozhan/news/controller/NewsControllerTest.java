package by.korozhan.news.controller;

import by.korozhan.news.model.News;
import by.korozhan.news.service.INewsService;
import by.korozhan.news.util.DateUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.Date;

import static by.korozhan.news.util.Constants.API_NEWS;
import static by.korozhan.news.util.Matchers.validBsonId;
import static java.lang.System.currentTimeMillis;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Veronika Korozhan March 12, 2018.
 */
public class NewsControllerTest extends AbstractControllerTest{
    @Autowired
    private INewsService newsService;

    private News testNews;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        testNews = newsService.save(new News(new Date(), "test title", "test body"));
    }

    @After
    public void tearDown() throws Exception {
        newsService.deleteAll();
    }

    @Test
    public void getAllNews() throws Exception {
        mockMvc.perform(get(API_NEWS))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(validBsonId()))
                .andExpect(jsonPath("$[0].title").value(testNews.getTitle()))
                .andExpect(jsonPath("$[0].body").value(testNews.getBody()))
                .andExpect(jsonPath("$[0].publicDate").value(DateUtil.dateToString(testNews.getPublicDate(), DateUtil.FORMAT_YMD_UNDERLINE)))
                .andDo(print());
    }

    @Test
    public void getNews() throws Exception {
        mockMvc.perform(get(String.join("/", API_NEWS, testNews.getId()))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(validBsonId()))
                .andExpect(jsonPath("$.title").value(testNews.getTitle()))
                .andExpect(jsonPath("$.body").value(testNews.getBody()))
                .andDo(print());
    }

    @Test
    public void saveNews() throws Exception {
        News news = new News(new Date(), "test new title", "test new body");
        mockMvc.perform(post(API_NEWS)
                .content(objectMapper.writeValueAsString(news))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(validBsonId()))
                .andExpect(jsonPath("$.title").value(news.getTitle()))
                .andExpect(jsonPath("$.body").value(news.getBody()))
                .andDo(print());
    }

    @Test
    public void updateNews() throws Exception {
        testNews.setTitle(testNews.getTitle() + currentTimeMillis());
        testNews.setBody(testNews.getBody() + currentTimeMillis());
        mockMvc.perform(put(API_NEWS)
                .content(objectMapper.writeValueAsString(testNews))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(validBsonId()))
                .andExpect(jsonPath("$.title").value(testNews.getTitle()))
                .andExpect(jsonPath("$.body").value(testNews.getBody()))
                .andDo(print());
    }

    @Test
    public void deleteNews() throws Exception {
        mockMvc.perform(delete(String.join("/", API_NEWS, testNews.getId())))
                .andExpect(status().isOk())
                .andDo(print());
        assertFalse(newsService.exists(testNews.getId()));
    }

}