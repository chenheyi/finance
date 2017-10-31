package com.ptg.payment.service;


import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpTradePaymentRecord;
import com.ptg.payment.pojo.vo.RpTradePaymentOrderQuery;

/**
 * User: zhangpeng
 * Date: 2017/10/25
 * Time: 21:12
 * Version:V1.0
 */
public interface RpTradePaymentRecordService {
    Result<RpTradePaymentRecord> findRecordByPage(Page page, Order order, RpTradePaymentOrderQuery query);

}
