package com.abing.sell.dataobject.mapper;

import com.abing.sell.dataobject.ProductCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Test
    public void insertByMap() throws Exception {

        Map<String,Object> map=new HashMap<>();
        map.put("categoryName","凉菜帮");
        map.put("category_type",6);
       int result= productCategoryMapper.insertByMap(map);
        Assert.assertEquals(1,result);
    }

    @Test
    public void insertByObject() throws Exception {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("热菜榜");
        productCategory.setCategoryType(7);
        int result=productCategoryMapper.insertByObject(productCategory);
        Assert.assertEquals(1,result);

    }

    @Test
    public void findByCategoryType()throws Exception{
        ProductCategory productCategory=productCategoryMapper.findByCategoryType(5);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void updateByCategoryType()throws Exception{
       int result= productCategoryMapper.updateByCategoryType("师兄最不爱",5);
        Assert.assertEquals(1,result);
    }

    @Test
    public void updateByObject() throws Exception{
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("师兄最爱");
        productCategory.setCategoryType(5);
        int result =productCategoryMapper.updateByObject(productCategory);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deleteByCategoryType()throws Exception{
        int result=productCategoryMapper.deleteByCategoryType(6);
        Assert.assertEquals(1,result);
    }

    @Test
    public void selectByCategoryType(){
        ProductCategory productCategory=productCategoryMapper.selectByCategoryType(5);
        Assert.assertNotNull(productCategory);
    }

}