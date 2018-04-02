package com.abing.sell.repository;

import com.abing.sell.dataobject.OrderMaster;
import com.abing.sell.enums.OrderStatusEnums;
import com.abing.sell.enums.PayStatusEnums;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request=new PageRequest(0,2);
        Page<OrderMaster> orderMasterPage=orderMasterRepository.findByBuyerOpenid("110110",request);

        System.out.println(orderMasterPage.toString());
    }

    @Test
    public void saveTest(){

        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("333222");
        orderMaster.setBuyerName("abing");
        orderMaster.setBuyerPhone("17321436171");
        orderMaster.setBuyerAddress("上海");
        orderMaster.setBuyerOpenid("110123");
        orderMaster.setOrderAmount(new BigDecimal(50));
        orderMaster.setOrderStatus(OrderStatusEnums.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnums.NEW.getCode());
        OrderMaster master=orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(master);
    }

}