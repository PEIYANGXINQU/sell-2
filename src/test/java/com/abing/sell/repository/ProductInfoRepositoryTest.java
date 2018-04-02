package com.abing.sell.repository;

import com.abing.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {

        List<ProductInfo> productInfoList=productInfoRepository.findByProductStatus(0);
        System.out.println(productInfoList.toString());

    }

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("125896");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(55.2));
        productInfo.setProductStock(10);
        productInfo.setProductDescription("滋阴大补 开胃健脾");
        productInfo.setProductIcon("http:13.png");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);
        productInfoRepository.save(productInfo);
    }

}