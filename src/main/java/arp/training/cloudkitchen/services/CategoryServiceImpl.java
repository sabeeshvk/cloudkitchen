package arp.training.cloudkitchen.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arp.training.cloudkitchen.model.Category;
import arp.training.cloudkitchen.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Override
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Category category) {
        categoryRepository.save(category);
    log.info("Logger : " + category.getCategoryId());
}

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategory(Long id) {
        Category c= categoryRepository.getReferenceById(id);
       log.info("Logger : " + c.getCategoryName());
        return c;
    }

}
