package com.abing.sell.dto;

import com.abing.sell.dataobject.OrderDetail;
import com.abing.sell.enums.OrderStatusEnums;
import com.abing.sell.enums.PayStatusEnums;
import com.abing.sell.utils.EnumsUtils;
import com.abing.sell.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/10/15 0015.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /**订单id*/
    private String orderId;

    /**买家姓名*/
    private String buyerName;

    /**买家手机号码*/
    private String buyerPhone;

    /**买家送货地址*/
    private String buyerAddress;

    /**买家微信openid*/
    private String buyerOpenid;

    /**订单总额*/
    private BigDecimal orderAmount;

    /**订单状态*/
    private Integer orderStatus;

    /**支付状态*/
    private Integer payStatus;

    /**创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList=new ArrayList<>();

    //当对象返回json格式时 添加 @JsonIgnore注解会忽略掉该字段
    @JsonIgnore
    public OrderStatusEnums getOrderStatusEnum() {
        return EnumsUtils.getEnumsByCode(orderStatus , OrderStatusEnums.class);
    }
    //当对象返回json格式时 添加 @JsonIgnore注解会忽略掉该字段
    @JsonIgnore
    public PayStatusEnums getPayStatusEnum() {
        return EnumsUtils.getEnumsByCode(payStatus , PayStatusEnums.class);
    }
}
