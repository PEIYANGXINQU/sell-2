package com.abing.sell.service.impl;

import com.abing.sell.dto.OrderDTO;
import com.abing.sell.enums.ResultEnum;
import com.abing.sell.exception.SellException;
import com.abing.sell.service.OrderService;
import com.abing.sell.service.PayService;
import com.abing.sell.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lly835.bestpay.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class PayServiceImpl implements PayService{


    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;
    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest=new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName("微信点餐订单");
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[微信支付] request={}",payRequest);
        PayResponse payResponse=bestPayService.pay(payRequest);
        log.info("[微信支付] payResponse={}",payResponse);

        return payResponse;
    }

    /**
     * 支付成功后修改订单的状态
     * @param notifyData
     * @return
     */
    @Override
    public PayResponse notify(String notifyData) {
        //安全问题  1 验证签名  2支付的状态 3支付的金额 4 支付人（下单人==支付人）

        //获得微信支付返回的值
        PayResponse payResponse=bestPayService.asyncNotify(notifyData);
        log.info("[微信支付] 异步通知，payResponse={}", JsonUtil.toJson(payResponse));

        //修改订单支付状态
        OrderDTO orderDTO=orderService.findOne(payResponse.getOrderId());
        //判断订单是否存在
        if (orderDTO==null){
            log.error("[微信支付 异步通知，订单不存在，orderId={}]",payResponse.getOrderId());
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //判断金额是否一致(0.10 0.1)
        if (MathUtil.equals(orderDTO.getOrderAmount().doubleValue(),payResponse.getOrderAmount()))
        {
            log.error("[微信支付] 异步通知，订单金额不一致 orderid={}，微信通知金额={}，系统金额={}",
                    payResponse.getOrderId(),payResponse.getOrderAmount(),orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_VERIFY_ERROR);
        }
        //修改订单支付状态
        orderService.pay(orderDTO);
        return payResponse;
    }

    /**
     * 退款
     * @param orderDTO
     */
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest=new RefundRequest();
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("[微信退款] refundRequest={}",JsonUtil.toJson(refundRequest));
        RefundResponse refundResponse=bestPayService.refund(refundRequest);
        log.info("[微信退款] refundResponse={}",JsonUtil.toJson(refundResponse));
        return refundResponse;
    }
}
