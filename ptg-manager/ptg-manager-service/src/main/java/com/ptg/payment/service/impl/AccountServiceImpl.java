package com.ptg.payment.service.impl;

import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.dao.RpAccountCustomMapper;
import com.ptg.payment.pojo.vo.AccountQuery;
import com.ptg.payment.pojo.vo.RpAccountCustom;
import com.ptg.payment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: lienjiaa
 * Date: 2017/10/26
 * Time: 20:11
 * Version:V1.0
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private RpAccountCustomMapper accountCustomMapper;
    @Override
    public Result<RpAccountCustom> listAccountItems(Page page, Order order, AccountQuery query) {
        Map<String,Object> map = new HashMap<>();
        map.put("page", page);
        map.put("order", order);
        map.put("query",query);
       long total = accountCustomMapper.countItems(map);
        List<RpAccountCustom> rows = accountCustomMapper.listItemsByPage(map);
        Result<RpAccountCustom> rs = new Result<>();
        rs.setTotal(total);
        rs.setRows(rows);
        return rs;
    }
}
