package com.abing.sell.controller;


import com.abing.sell.dataobject.ProductCategory;
import com.abing.sell.dataobject.ProductInfo;
import com.abing.sell.service.CategoryService;
import com.abing.sell.service.ProductInfoService;
import com.abing.sell.utils.ResultVOUtil;
import com.abing.sell.vo.ProductInfoVO;
import com.abing.sell.vo.ProductVO;
import com.abing.sell.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {


    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
//    @Cacheable(cacheNames = "productList",key = "123")  //在接口实现类中配置
//    @Cacheable(cacheNames = "productList",key = "#sellerId",condition = "#sellerId.length()>3",unless = "#result.getCode()!=0")//key = "#sellerId"动态实现key ,  condition = "#sellerId.length()>3"当长度大于3是缓存否则不缓存, unless = "#result.getCode()!=0"当code等于0查询成功的的时候开始缓存
//    public ResultVO list(@RequestParam("sellerId") String sellerId){
    public ResultVO list(){

        //1.查询所有的上架商品
        List<ProductInfo> productInfoList=productInfoService.findUpAll();

        //2.查询类目
        //c传统方法
//        List<Integer> categoryTypeList=new ArrayList<Integer>();
//        for (ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        List<Integer> categoryTypeList=productInfoList.stream()
                .map(e ->e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList=categoryService.findByCategoryTypeIn(categoryTypeList);


        System.out.println("------------"+productInfoList);
        System.out.println("============"+productCategoryList);
        //3数据拼装
        List<ProductVO> productVOList=new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO=new ProductVO();
            BeanUtils.copyProperties(productCategory,productVO);

            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo: productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
                productVO.setProductInfoVOList(productInfoVOList);
            }

            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
