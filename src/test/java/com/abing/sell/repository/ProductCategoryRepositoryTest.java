package com.abing.sell.repository;

import com.abing.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;
    @Test
    public void findOneTest(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println("+++++++++++"+productCategory.toString());
    }

    @Test
//    @Transactional  测试  在数据库中数据不存在
    public void saveTest(){
        ProductCategory productCategory =new ProductCategory("热菜榜",4);
        ProductCategory result=repository.save(productCategory);
        Assert.assertNotNull(result);

    }

    @Test
    public void updateText(){
        ProductCategory productCategory =new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("男生最爱111");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list= Arrays.asList(2,3,4);
        List<ProductCategory> repositoryByCategoryTypeIn=repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,repositoryByCategoryTypeIn.size());
    }
}