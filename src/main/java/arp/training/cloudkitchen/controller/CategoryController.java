package arp.training.cloudkitchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arp.training.cloudkitchen.model.Category;
import arp.training.cloudkitchen.services.CategoryService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.models.annotations.OpenAPI30;


@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/menu/v1/category")
    @RateLimiter(name = "postCategory")
    @OpenAPI30
    private void saveCategory(@RequestBody Category category) {
         categoryService.saveOrUpdate(category);
    }

    @GetMapping(value = "/menu/v1/categories")
    @RateLimiter(name = "getCategories")
    @OpenAPI30
    public List<Category> getCategories() {
        return categoryService.getCategoryList();
    }

    @GetMapping(value = "/menu/v1/category/{categoryId}")
    @RateLimiter(name = "getCategoryById")
    @OpenAPI30
    public Category getCategory(@PathVariable("categoryId") Long categeoryId) {
        return categoryService.getCategory(categeoryId);
    }


    @DeleteMapping("/menu/v1/category/{categoryId}")
    @RateLimiter(name = "deleteCategoryById")
    @OpenAPI30
    private void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }

}
