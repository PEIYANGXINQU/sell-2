package com.abing.sell.dataobject;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class ProductCategory {
    /**
     * category_id INT NOT NULL AUTO_INCREMENT,
     * category_name VARCHAR(64) NOT NULL COMMENT '类目名',
     * category_type INT NOT NULL COMMENT '类目编号',
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    private Integer categoryType;

    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    public ProductCategory() {
    }

    public ProductCategory(String category_name, Integer categoryType) {
        this.categoryName = category_name;
        this.categoryType = categoryType;
    }

}