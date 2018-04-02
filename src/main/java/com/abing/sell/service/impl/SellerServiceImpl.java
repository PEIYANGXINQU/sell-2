package com.abing.sell.service.impl;

import com.abing.sell.dataobject.SellerInfo;
import com.abing.sell.repository.SellerInfoRepository;
import com.abing.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;


    @Override
    public SellerInfo findSellerInfoByOpenId(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
