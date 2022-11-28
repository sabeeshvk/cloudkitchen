package arp.training.cloudkitchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import arp.training.cloudkitchen.model.Product;
import arp.training.cloudkitchen.services.ProductService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/menu/v1/product")
    @RateLimiter(name = "postProduct")
    private long saveProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product.getProductId();
    }

    @GetMapping(value = "/menu/v1/products")
    @RateLimiter(name = "getProducts")
    public List<Product> getProduct() {
        return productService.getProductList();
    }

    @GetMapping(value = "/menu/v1/products/{productId}")
    @RateLimiter(name = "getproductById")
    public Product getProduct(@PathVariable("productId") Long productId) {
        return productService.getProduct(productId);
    }


    @DeleteMapping("/menu/v1/products/{productId}")
    @RateLimiter(name = "deleteProductById")
    private void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProductById(productId);
    }

}
