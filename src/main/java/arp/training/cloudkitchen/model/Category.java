package arp.training.cloudkitchen.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import org.springframework.data.relational.core.mapping.Table;

import org.slf4j.LoggerFactory;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table //(name="category")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {
    @Id
    private long categoryId;
    private String categoryName;

    // @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)   
    // private Set<Product> products ;

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Category.class);

    public Category () {
        log.info("%%%%%%%%  Category entity init  %%%%%%%%% ");
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
