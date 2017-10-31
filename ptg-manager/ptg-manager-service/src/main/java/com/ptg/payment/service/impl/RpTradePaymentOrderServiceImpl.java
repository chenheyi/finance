package com.ptg.payment.service.impl;


import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.dao.RpTradePaymentOrderCustomMapper;
import com.ptg.payment.pojo.po.RpTradePaymentOrder;
import com.ptg.payment.pojo.vo.RpTradePaymentOrderQuery;
import com.ptg.payment.service.RpTradePaymentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: zhangpeng
 * Date: 2017/10/25
 * Time: 9:59
 * Version:V1.0
 */
@Service
public class RpTradePaymentOrderServiceImpl implements RpTradePaymentOrderService {
    @Autowired
    private RpTradePaymentOrderCustomMapper rpTradePaymentOrderCustomDao;

    public Result<RpTradePaymentOrder> findOrderByPage(Page page, Order order, RpTradePaymentOrderQuery query) {
        Map map = new HashMap<String, Object>();
        map.put("page", page);
        map.put("order", order);
        map.put("query", query);
        List<RpTradePaymentOrder> rows = rpTradePaymentOrderCustomDao.selectOrderByPage(map);

        long total = rpTradePaymentOrderCustomDao.selectOrderCount(map);
        Result<RpTradePaymentOrder> result= new Result<RpTradePaymentOrder>();
        result.setRows(rows);
        result.setTotal(total);
        return result;
    }

}
