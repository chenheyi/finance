package com.ptg.payment.service.impl;

import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.dao.RpSettRecordCustomMapper;
import com.ptg.payment.dao.RpSettRecordMapper;
import com.ptg.payment.pojo.po.RpSettRecord;
import com.ptg.payment.pojo.vo.SettRecordQuery;
import com.ptg.payment.service.SettRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: lienjiaa
 * Date: 2017/10/25
 * Time: 20:08
 * Version:V1.0
 */
@Service
public class SettRecordServiceImpl implements SettRecordService {
    @Autowired
    private RpSettRecordMapper mapper;
    @Autowired
    private RpSettRecordCustomMapper settRecordCustomMapper;
    @Override
    public Result<RpSettRecord> listSRItems(Page page, Order order, SettRecordQuery query) {
        Map<String,Object> map = new HashMap<>();
        map.put("page", page);
        map.put("order", order);
        map.put("query",query);
        long total = settRecordCustomMapper.countItems(map);
        List<RpSettRecord> rows = settRecordCustomMapper.listItemsByPage(map);
        Result<RpSettRecord> rs = new Result<>();
        rs.setRows(rows);
        rs.setTotal(total);
        return rs;
    }

    @Override
    public RpSettRecord findById(String id) {
        return mapper.selectByPrimaryKey(id);
    }
}
