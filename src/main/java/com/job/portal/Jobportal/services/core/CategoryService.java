package com.job.portal.Jobportal.services.core;

import com.job.portal.Jobportal.models.core.Category;
import com.job.portal.Jobportal.repository.core.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category create(Category category) {
        var newCategory = this.categoryRepository.save(category);
        return newCategory;
    }

    public Category update(Category category) {
        var newCategory = this.categoryRepository.save(category);
        return newCategory;
    }

    public void delete(Integer id) {
        this.categoryRepository.deleteById(id);
    }
}
