package arp.training.cloudkitchen.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arp.training.cloudkitchen.model.Product;
import arp.training.cloudkitchen.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
   
    @Override
    public List<Product> getProductList() {
        List<Product> products = productRepository.findAll();
        log.info("Number of produts: " + products.size());
        return products;
    }

    @Override
    public void saveOrUpdate(Product product) {
        productRepository.save(product);
        log.info("Product saved , ID = " + product.getProductId());
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.getReferenceById(id);
    }

}
