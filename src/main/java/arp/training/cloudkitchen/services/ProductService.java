package arp.training.cloudkitchen.services;

import java.util.List;

import arp.training.cloudkitchen.model.Product;

public interface ProductService {

    public List<Product> getProductList() ;

    public Product getProduct(Long id) ;

    public void saveOrUpdate(Product product) ;

    public void deleteProductById(Long id) ;

}
