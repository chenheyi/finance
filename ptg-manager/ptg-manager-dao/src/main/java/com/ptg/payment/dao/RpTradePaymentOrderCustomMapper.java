package com.ptg.payment.dao;

import com.ptg.payment.pojo.po.RpTradePaymentOrder;

import java.util.List;
import java.util.Map;

/**
 * User: zhangpeng
 * Date: 2017/10/25
 * Time: 11:00
 * Version:V1.0
 */
public interface RpTradePaymentOrderCustomMapper {
    long selectOrderCount(Map<String, Object> map);
    List<RpTradePaymentOrder> selectOrderByPage(Map<String, Object> map);
}
