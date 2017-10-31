package com.ptg.payment.service;


import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpTradePaymentOrder;
import com.ptg.payment.pojo.vo.RpTradePaymentOrderQuery;


/**
 * User: zhangpeng
 * Date: 2017/10/25
 * Time: 9:59
 * Version:V1.0
 */
public interface RpTradePaymentOrderService {
    Result<RpTradePaymentOrder> findOrderByPage(Page page, Order order, RpTradePaymentOrderQuery query);
}
