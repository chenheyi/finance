package com.ptg.payment.service.impl;


import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.dao.RpTradePaymentRecordCustomMapper;
import com.ptg.payment.pojo.po.RpTradePaymentRecord;
import com.ptg.payment.pojo.vo.RpTradePaymentOrderQuery;
import com.ptg.payment.service.RpTradePaymentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: zhangpeng
 * Date: 2017/10/25
 * Time: 21:13
 * Version:V1.0
 */
@Service
public class RpTradePaymentRecordServiceImpl implements RpTradePaymentRecordService{
    @Autowired
    private RpTradePaymentRecordCustomMapper rpTradePaymentRecordCustomMapper;

    public Result<RpTradePaymentRecord> findRecordByPage(Page page, Order order, RpTradePaymentOrderQuery query) {
        Map map = new HashMap<String, Object>();
        map.put("page", page);
        map.put("order", order);
        map.put("query", query);
        List<RpTradePaymentRecord> rows = rpTradePaymentRecordCustomMapper.selectRecordByPage(map);
        long total = rpTradePaymentRecordCustomMapper.selectRecordCount(map);
        Result<RpTradePaymentRecord> result= new Result<RpTradePaymentRecord>();

        result.setRows(rows);
        result.setTotal(total);
        return result;
}}
