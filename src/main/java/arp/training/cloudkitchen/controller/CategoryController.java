package arp.training.cloudkitchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import arp.training.cloudkitchen.model.Category;
import arp.training.cloudkitchen.services.CategoryService;


@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/v1/category")
    private void saveCategory(@RequestBody Category category) {
         categoryService.saveOrUpdate(category);
    }

    @GetMapping(value = "/v1/categories")
    public List<Category> getCategory() {
        return categoryService.getCategoryList();
    }

    @DeleteMapping("/v1/category/{categoryId}")
    private void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }

}
