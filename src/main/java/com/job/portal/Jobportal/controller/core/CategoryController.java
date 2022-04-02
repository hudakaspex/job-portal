package com.job.portal.Jobportal.controller.core;

import com.job.portal.Jobportal.models.core.Category;
import com.job.portal.Jobportal.services.core.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class CategoryController {

    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }

    @PostMapping("/categories")
    public Category create(@RequestBody() Category category) {
        var newCategory = this.categoryService.create(category);
        return newCategory;
    }

    @PutMapping("/categories/{id}")
    public Category update(@PathVariable("id") Integer id, @RequestBody() Category category) {
        var categoryInDB = this.categoryService.findById(id).get();
        categoryInDB.setName(category.getName());
        categoryInDB.setDescription(category.getDescription());
        var newCategory = this.categoryService.update(categoryInDB);
        return newCategory;
    }

    @DeleteMapping("/categories/{id}")
    public void delete(@PathVariable("id") Integer id) {
        this.categoryService.delete(id);
    }

    @PostMapping("/categories/deleteByIds")
    public void deleteByIds(@RequestBody() List<Integer> ids) {
        this.categoryService.deleteByIds(ids);
    }
}
