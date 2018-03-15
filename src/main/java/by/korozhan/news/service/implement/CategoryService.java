package by.korozhan.news.service.implement;

import by.korozhan.news.model.Category;
import by.korozhan.news.repository.CategoryRepository;
import by.korozhan.news.service.ICategoryService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    @Override
    public void delete(String hexId) {
        categoryRepository.deleteById(hexId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Category> findAll() {
        return Lists.newArrayList(categoryRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public Category findOne(String hexId) {
        return categoryRepository.findById(hexId).orElse(null);
    }


    @Override
    public boolean exists(String hexId) {
        return categoryRepository.existsById(hexId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Category> findByName(String displayName) {
        return Lists.newArrayList(categoryRepository.findByDisplayName(displayName));
    }

    @Transactional
    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
