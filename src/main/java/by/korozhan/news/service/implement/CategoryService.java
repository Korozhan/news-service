package by.korozhan.news.service.implement;

import by.korozhan.news.model.Category;
import by.korozhan.news.repository.CategoryRepository;
import by.korozhan.news.service.ICategoryService;
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
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Category> findAll() {
        return Lists.newArrayList(categoryRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Category> findOne(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return categoryRepository.existsById(id);
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Category> findByName(String displayName) {
        return Lists.newArrayList(categoryRepository.findByName(displayName));
    }
}
