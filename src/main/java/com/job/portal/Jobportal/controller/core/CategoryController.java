package com.job.portal.Jobportal.controller.core;

import com.job.portal.Jobportal.models.core.Category;
import com.job.portal.Jobportal.services.core.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findAll() {
        var categories = this.categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
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
    public ResponseEntity<String> deleteByIds(@RequestBody() List<Integer> ids) {
        try {
            this.categoryService.deleteByIds(ids);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Error err) {
            return new ResponseEntity<>(err.getMessage(), HttpStatus.EXPECTATION_FAILED);
        }
    }
}
