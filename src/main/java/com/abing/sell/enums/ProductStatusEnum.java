package com.abing.sell.enums;

import lombok.Getter;

/**
 * 商品状态
 */

@Getter
public enum ProductStatusEnum implements CodeEnums{
    UP(0,"上架商品"),
    DOWN(1,"下架商品");
    private Integer code;

    private String message;


    ProductStatusEnum(int i, String s) {
        this.code=i;
        this.message=s;

    }
}
