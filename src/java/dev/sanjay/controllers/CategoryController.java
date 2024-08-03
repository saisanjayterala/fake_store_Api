package dev.sanjay.controllers;

import dev.sanjay.dtos.ExceptionDto;
import dev.sanjay.models.Category;
import dev.sanjay.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable("id") Long id) {
        try {
            Category category = categoryService.getCategoryById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (RuntimeException exception) {
            ExceptionDto dto = new ExceptionDto();
            dto.setMessage("Category not found");
            return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
