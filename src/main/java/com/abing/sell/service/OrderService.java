package com.abing.sell.service;

import com.abing.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**查找单个订单.*/
    OrderDTO findOne(String orderId);

    /**查找订单.**/
    Page<OrderDTO> findList(String buyerOpenid , Pageable pageable);

    /**取消订单.**/
    OrderDTO cancel(OrderDTO orderDTO);

    /**完结订单.**/
    OrderDTO finish(OrderDTO orderDTO);

    /**支付订单.**/
    OrderDTO pay(OrderDTO orderDTO);

    /**查找订单.**/
    Page<OrderDTO> findList(Pageable pageable);
}
