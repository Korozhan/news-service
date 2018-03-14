package by.korozhan.news.service.implement;

import by.korozhan.news.model.News;
import by.korozhan.news.repository.NewsRepository;
import by.korozhan.news.service.INewsService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Veronika Korozhan March 11, 2018.
 */
@Service
public class NewsService implements INewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Transactional
    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        newsRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<News> findAll() {
        return Lists.newArrayList(newsRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<News> findOne(Integer id) {
        return newsRepository.findById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return newsRepository.existsById(id);
    }

    @Override
    public long count() {
        return newsRepository.count();
    }

    @Transactional(readOnly = true)
    @Override
    public List<News> findByTiltle(String title) {
        return Lists.newArrayList(newsRepository.findByTitle(title));
    }
}
