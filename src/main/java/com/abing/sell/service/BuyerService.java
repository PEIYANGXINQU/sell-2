package com.abing.sell.service;

import com.abing.sell.dto.OrderDTO;

public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderid);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderid);
}
