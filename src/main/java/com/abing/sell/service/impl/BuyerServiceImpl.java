package com.abing.sell.service.impl;

import com.abing.sell.dto.OrderDTO;
import com.abing.sell.enums.ResultEnum;
import com.abing.sell.exception.SellException;
import com.abing.sell.service.BuyerService;
import com.abing.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderid) {
        return  checkOrderOwner(openid,orderid);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderid) {
        OrderDTO orderDTO=checkOrderOwner(openid,orderid);
        if (orderDTO==null){
            log.error("[取消订单] 查不到该订单，orderId={}",orderid);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }
    private OrderDTO checkOrderOwner(String openid, String orderid){
        OrderDTO orderDTO=orderService.findOne(orderid);
        if (orderDTO==null){
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("[查询订单] 订单的openid不一致");
            throw new SellException(ResultEnum.NOT_CURRENT_USER);
        }
        return orderDTO;
    }
}
