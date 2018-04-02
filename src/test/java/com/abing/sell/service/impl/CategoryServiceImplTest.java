package com.abing.sell.service.impl;

import com.abing.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory=categoryServiceImpl.findOne(1);
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> productCategoryList=categoryServiceImpl.findAll();
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList=categoryServiceImpl.findByCategoryTypeIn(Arrays.asList(2,3,4));
        Assert.assertNotEquals(0,productCategoryList.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory=new ProductCategory("男生专享",4);
        ProductCategory result=categoryServiceImpl.save(productCategory);
        Assert.assertEquals(new Integer(4),productCategory.getCategoryType());
    }

}