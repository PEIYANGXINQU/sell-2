package com.abing.sell.service;

import com.abing.sell.dataobject.ProductInfo;
import com.abing.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 */
public interface ProductInfoService {

    public ProductInfo findOne(String  id);

    /**
     * 查询在架商品
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findByPage(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 减少库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 增加库存
     */
    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 商品下架
     */
    ProductInfo offSafe(String productId);

    /**
     * 商品上架
     */
    ProductInfo onSafe(String productId);


}
