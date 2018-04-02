package com.abing.sell.dataobject;

import com.abing.sell.enums.ProductStatusEnum;
import com.abing.sell.utils.EnumsUtils;
import com.abing.sell.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductInfo {

    /** 商品id .*/
    @Id
    private String productId;

    /**商品名称*/
    private String productName;

    /**商品单价*/
    private BigDecimal productPrice;

    /**商品库存*/
    private Integer productStock;

    /**商品描述*/
    private String productDescription;

    /**商品小图*/
    private String productIcon;

    /**商品类目*/
    private Integer categoryType;

    /**商品状态 0正常  1下架*/
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /**创建时间*/
//    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumsUtils.getEnumsByCode(productStatus,ProductStatusEnum.class);
    }

}
