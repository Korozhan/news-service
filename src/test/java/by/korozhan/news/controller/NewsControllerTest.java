package by.korozhan.news.controller;

import by.korozhan.news.config.AppConfig;
import by.korozhan.news.config.WebConfig;
import by.korozhan.news.model.News;
import by.korozhan.news.service.INewsService;
import by.korozhan.news.util.DateUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static by.korozhan.news.util.Matchers.validBsonId;
import static java.lang.System.currentTimeMillis;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * Veronika Korozhan March 12, 2018.
 */
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class})
public class NewsControllerTest {
    private static final String API_NEWS = "/api/news";

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private INewsService newsService;

    private News testNews;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
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
        mockMvc.perform(get(API_NEWS + "/" + testNews.getId())
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
        News news = new News(new Date(), "test-new-title", "test-new-body");
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
        mockMvc.perform(delete(API_NEWS + "/" + testNews.getId()))
                .andExpect(status().isOk())
                .andDo(print());
        assertFalse(newsService.exists(testNews.getId()));
    }

}