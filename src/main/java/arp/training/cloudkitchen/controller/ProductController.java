package arp.training.cloudkitchen.controller;

import java.util.List;

import com.google.gson.Gson;

import org.slf4j.LoggerFactory;
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
import io.swagger.v3.oas.models.annotations.OpenAPI30;


@RestController
public class ProductController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @PostMapping("/menu/v1/product")
//    @RateLimiter(name = "postProduct")  // Commenting as this is causing issue
    @OpenAPI30
    private long saveProduct(@RequestBody Product product) {
        log.info("Product " + new Gson().toJson(product));
        productService.saveOrUpdate(product);
        return product.getProductId();
    }

    @GetMapping(value = "/menu/v1/products")
//    @RateLimiter(name = "getProducts")
    @OpenAPI30
    public List<Product> getProduct() {
        return productService.getProductList();
    }

    @GetMapping(value = "/menu/v1/products/{productId}")
//    @RateLimiter(name = "getproductById")
    @OpenAPI30
    public Product getProduct(@PathVariable("productId") Long productId) {
        return productService.getProduct(productId);
    }


    @DeleteMapping("/menu/v1/products/{productId}")
//    @RateLimiter(name = "deleteProductById")
    @OpenAPI30
    private void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProductById(productId);
    }

}
