package arp.training.cloudkitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arp.training.cloudkitchen.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {

    
}
