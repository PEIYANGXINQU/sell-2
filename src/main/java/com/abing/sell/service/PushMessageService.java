package com.abing.sell.service;

import com.abing.sell.dto.OrderDTO;

/**
 * 推送消息
 */
public interface PushMessageService {

    /**
     * 订单消息状态
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
