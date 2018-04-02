package com.abing.sell.service.impl;

import com.abing.sell.dataobject.ProductInfo;
import com.abing.sell.repository.ProductInfoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {


    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo=productInfoService.findOne("123456");

        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
    }

    @Test
    public void findByPage() throws Exception {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<ProductInfo> productInfoPage=productInfoService.findByPage(pageRequest);
        System.out.println("----------"+productInfoPage.getTotalElements());
    }

    @Test
    public void save() throws Exception {
    }

    @Test
    public void decreaseStock() throws Exception {
    }

    @Test
    public void increaseStock() throws Exception {
    }

    @Test
    public void offSafe() throws Exception {
    }

    @Test
    public void onSafe() throws Exception {
    }

}