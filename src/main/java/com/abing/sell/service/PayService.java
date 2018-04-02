package com.abing.sell.service;


import com.abing.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

public interface PayService {

    public PayResponse create(OrderDTO orderDTO);

    public PayResponse notify(String notifyData);

    public RefundResponse refund(OrderDTO orderDTO);
}
