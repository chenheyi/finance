package com.ptg.payment.service;

import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpPayProduct;
import com.ptg.payment.pojo.vo.PayProductQuery;

import java.util.List;

/**
 * User: chenbo
 * Date: 2017/10/25
 * Time: 21:02
 * Version:V1.0
 */
public interface PayProductService {
   //List<RpPayProduct> listProducts();

    Result<RpPayProduct> listProducts(Page page, PayProductQuery query);

    int upProductStatusByIds  (List<String> ids);

    int downProductStatusByIds  (List<String> ids);
}
