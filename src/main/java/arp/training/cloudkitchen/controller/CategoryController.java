package arp.training.cloudkitchen.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.LoggerFactory;
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

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    CategoryService categoryService;

    @PostMapping("/menu/v1/category")
  //  @RateLimiter(name = "postCategory")
    @OpenAPI30
    private void saveCategory(@RequestBody Category category) {
        try {
          log.info("%%%%%% Host: " + InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
          log.error("Host: unknown");
        }

        log.info("Category " + category);
        categoryService.saveOrUpdate(category);
    }

    @GetMapping(value = "/menu/v1/categories")
   // @RateLimiter(name = "getCategories")
    @OpenAPI30
    public List<Category> getCategories() {
      try {
        log.info("%%%%%% Host: " + InetAddress.getLocalHost().getHostName());
      } catch (UnknownHostException e) {
        log.error("Host: unknown");
      }
      return categoryService.getCategoryList();
    }

    @GetMapping(value = "/menu/v1/category/{categoryId}")
  //  @RateLimiter(name = "getCategoryById")
    @OpenAPI30
   public Category getCategory(@PathVariable("categoryId") Long categeoryId) {
      try {
        log.info("%%%%%% Host: " + InetAddress.getLocalHost().getHostName());
      } catch (UnknownHostException e) {
        log.error("Host: unknown");
      }
      return categoryService.getCategory(categeoryId);
    }


    @DeleteMapping("/menu/v1/category/{categoryId}")
  //  @RateLimiter(name = "deleteCategoryById")
    @OpenAPI30
    private void deleteCategory(@PathVariable("categoryId") Long categoryId) {
      try {
        log.info("%%%%%% Host: " + InetAddress.getLocalHost().getHostName());
      } catch (UnknownHostException e) {
        log.error("Host: unknown");
      }
      categoryService.deleteCategoryById(categoryId);
    }

}
