package by.korozhan.news.controller;

import by.korozhan.news.config.AppConfig;
import by.korozhan.news.config.WebConfig;
import by.korozhan.news.model.Category;
import by.korozhan.news.model.News;
import by.korozhan.news.service.ICategoryService;
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

import java.util.Arrays;
import java.util.Date;

import static by.korozhan.news.util.Matchers.validBsonId;
import static java.lang.System.currentTimeMillis;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Veronika Korozhan March 12, 2018.
 */

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class, WebConfig.class})
public class CategoryControllerTest {
    private static final String API_CATEGORY = "/api/category";

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ICategoryService categoryService;

    private Category testCategory;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        testCategory = categoryService.save(new Category("test display name", Arrays.asList(new News(new Date(), "test title", "test body"))));
    }

    @After
    public void tearDown() throws Exception {
        categoryService.deleteAll();
    }

    @Test
    public void getAllCategories() throws Exception {
        mockMvc.perform(get(API_CATEGORY))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].id").value(validBsonId()))
                .andExpect(jsonPath("$[0].displayName").value(testCategory.getDisplayName()))
                .andExpect(jsonPath("$[0].news").value(testCategory.getNews()))
                .andDo(print());
    }

    @Test
    public void getCategory() throws Exception {
        mockMvc.perform(get(API_CATEGORY + "/" + testCategory.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(validBsonId()))
                .andExpect(jsonPath("$.displayName").value(testCategory.getDisplayName()))
                .andDo(print());
    }

    @Test
    public void saveCategory() throws Exception {
        Category category = new Category("test display name", Arrays.asList(new News(new Date(), "test title", "test body")));
        mockMvc.perform(post(API_CATEGORY)
                .content(objectMapper.writeValueAsString(category))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(validBsonId()))
                .andExpect(jsonPath("$.displayName").value(category.getDisplayName()))
                .andExpect(jsonPath("$.news").value(category.getNews()))
                .andDo(print());
    }

    @Test
    public void updateCategory() throws Exception {
        testCategory.setDisplayName(testCategory.getDisplayName() + currentTimeMillis());
        mockMvc.perform(put(API_CATEGORY)
                .content(objectMapper.writeValueAsString(testCategory))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(validBsonId()))
                .andExpect(jsonPath("$.displayName").value(testCategory.getDisplayName()))
                .andExpect(jsonPath("$.news").value(testCategory.getNews()))
                .andDo(print());
    }

    @Test
    public void deleteCategory() throws Exception {
        mockMvc.perform(delete(API_CATEGORY + "/" + testCategory.getId()))
                .andExpect(status().isOk())
                .andDo(print());
        assertFalse(categoryService.exists(testCategory.getId()));
    }

}