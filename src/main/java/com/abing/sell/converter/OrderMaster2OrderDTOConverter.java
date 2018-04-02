package com.abing.sell.converter;

import com.abing.sell.dataobject.OrderMaster;
import com.abing.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMaster2OrderDTOConverter {


    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
//        for (int i=0;i<orderMasterList.size();i++){
//            convert(orderMasterList.get(i));
//        }
        return orderMasterList.stream().map(e ->convert(e)).collect(Collectors.toList());
    }
}
