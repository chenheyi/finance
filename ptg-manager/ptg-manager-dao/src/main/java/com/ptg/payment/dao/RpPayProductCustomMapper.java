package com.ptg.payment.dao;

import com.ptg.payment.pojo.po.RpPayProduct;

import java.util.List;
import java.util.Map;

public interface RpPayProductCustomMapper {
    List<RpPayProduct> listPayProducts(Map<String,Object> map);

    long countPayProducts(Map<String,Object> map);
}