package com.abing.sell.service.impl;

import com.abing.sell.dto.OrderDTO;
import com.abing.sell.service.OrderService;
import com.abing.sell.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private PushMessageService pushMessageService;
    @Autowired
    private OrderService orderService;
    @Test
    public void orderStatus() throws Exception {
        OrderDTO orderDTO=orderService.findOne("111222");
        pushMessageService.orderStatus(orderDTO);

    }

}