package com.abing.sell.repository;

import com.abing.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Test
    public void findByOrderId() throws Exception {


    }

    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("2222222");
        orderDetail.setOrderId("111222");
        orderDetail.setProductIcon("http:123.png");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(52.2));
        orderDetail.setProductQuantity(2);

        OrderDetail result=orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(orderDetail);
    }

}