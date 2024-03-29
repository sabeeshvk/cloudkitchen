package arp.training.cloudkitchen.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arp.training.cloudkitchen.model.Product;
import jakarta.persistence.QueryHint;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long>  {

    
}
