package com.ptg.payment.service.impl;

import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.dao.RpAccountHistoryCustomMapper;
import com.ptg.payment.pojo.po.RpAccountHistory;
import com.ptg.payment.pojo.vo.AccountQuery;
import com.ptg.payment.pojo.vo.RpAccountCustom;
import com.ptg.payment.pojo.vo.RpAccountHistoryCustom;
import com.ptg.payment.service.AccountHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: lienjiaa
 * Date: 2017/10/27
 * Time: 22:01
 * Version:V1.0
 */
@Service
public class AccountHistoryServiceImpl implements AccountHistoryService {
    @Autowired
    private RpAccountHistoryCustomMapper accountHistoryCustomMapper;
    @Override
    public Result<RpAccountHistoryCustom> listAHItems(Page page, Order order, AccountQuery query) {
        Map<String,Object> map = new HashMap<>();
        map.put("page", page);
        map.put("order", order);
        map.put("query",query);
        long total = accountHistoryCustomMapper.countItems(map);
        List<RpAccountHistoryCustom> rows = accountHistoryCustomMapper.listItemsByPage(map);
        Result<RpAccountHistoryCustom> rs = new Result<>();
        rs.setTotal(total);
        rs.setRows(rows);
        return rs;
    }
}
