package arp.training.cloudkitchen.services;

import java.util.List;

import arp.training.cloudkitchen.model.Category;

public interface CategoryService {

    public List<Category> getCategoryList();

    public Category getCategory(Long id);

    public void saveOrUpdate(Category category) ;

    public void deleteCategoryById(Long id) ;

}