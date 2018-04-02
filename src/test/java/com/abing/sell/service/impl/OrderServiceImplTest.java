package com.abing.sell.service.impl;

import com.abing.sell.dataobject.OrderDetail;
import com.abing.sell.dto.OrderDTO;
import com.abing.sell.enums.OrderStatusEnums;
import com.abing.sell.enums.PayStatusEnums;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() throws Exception {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("abing");
        orderDTO.setBuyerPhone("17321436171");
        orderDTO.setBuyerAddress("上海");
        orderDTO.setBuyerOpenid("110110");

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(1);
        orderDetailList.add(orderDetail);
        OrderDetail orderDetai = new OrderDetail();
        orderDetai.setProductId("125896");
        orderDetai.setProductQuantity(2);
        orderDetailList.add(orderDetai);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("创建订单--------", result.toString());
    }

    @Test
    public void findOne() throws Exception {

    }

    @Test
    public void findList() throws Exception {
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO=orderService.findOne("111222");
        OrderDTO result=orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnums.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO=orderService.findOne("111222");
        OrderDTO result=orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnums.FINISH.getCode(),result.getOrderStatus());

    }

    @Test
    public void pay() throws Exception {
        OrderDTO orderDTO=orderService.findOne("1520847222666790434");
        OrderDTO result=orderService.pay(orderDTO);
        Assert.assertEquals(PayStatusEnums.FINISH.getCode(),result.getPayStatus());
    }

    @Test
    public void findList1() throws Exception {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage=orderService.findList(pageRequest);
        Assert.assertTrue("查询所有的订单列表",orderDTOPage.getTotalElements()>0);

    }

}