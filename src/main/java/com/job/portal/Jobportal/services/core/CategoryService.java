package com.job.portal.Jobportal.services.core;

import com.job.portal.Jobportal.models.core.Category;
import com.job.portal.Jobportal.repository.core.CategoryRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Optional<Category> findById(Integer id) {
        return this.categoryRepository.findById(id);
    }

    public Category create(@NotNull Category category) {
        category.setId(null);
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

    public void deleteByIds(List<Integer> ids) {
        this.categoryRepository.deleteAllById(ids);
    }
}
