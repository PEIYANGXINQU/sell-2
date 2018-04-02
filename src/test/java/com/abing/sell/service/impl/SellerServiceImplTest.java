package com.abing.sell.service.impl;

import com.abing.sell.dataobject.SellerInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerServiceImplTest {


    @Autowired
    private SellerServiceImpl sellerService;
    @Test
    public void findSellerInfoByOpenId() throws Exception {

        SellerInfo sellerInfo=sellerService.findSellerInfoByOpenId("abc");
        Assert.assertEquals("abc",sellerInfo.getOpenid());
    }

}