package com.abing.sell.service.impl;

import com.abing.sell.dataobject.ProductCategory;
import com.abing.sell.dataobject.dao.ProductCategoryDao;
import com.abing.sell.repository.ProductCategoryRepository;
import com.abing.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CategoryServiceImpl  implements CategoryService{

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

//    @Autowired
//    private ProductCategoryDao productCategoryDao;
//
//    public int insertByMap(Map<String,Object> map){
//        return productCategoryDao.insertByMap(map);
//    }


    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
