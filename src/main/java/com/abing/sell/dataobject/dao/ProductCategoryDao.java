package com.abing.sell.dataobject.dao;

import com.abing.sell.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ProductCategoryDao {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    public int insertByMap(Map<String,Object> map){

        return productCategoryMapper.insertByMap(map);
    }
}
