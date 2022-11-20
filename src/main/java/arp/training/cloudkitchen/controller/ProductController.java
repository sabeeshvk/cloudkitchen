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


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/v1/product")
    private long saveProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return product.getProductId();
    }

    @GetMapping(value = "/v1/products")
    public List<Product> getProduct() {
        return productService.getProductList();
    }

    @DeleteMapping("/v1/product/{productId}")
    private void deleteProduct(@PathVariable("productId") Long productId) {
        productService.deleteProductById(productId);
    }

}
