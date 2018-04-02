package com.abing.sell.service;

import com.abing.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.Optional;

/**
 * 类目
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
