package com.abing.sell.service;

import com.abing.sell.dataobject.SellerInfo;

public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenId(String openid);
}
