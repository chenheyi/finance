package com.ptg.payment.service.impl;

import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.dao.RpUserPayConfigCustomMapper;
import com.ptg.payment.pojo.po.RpPayProduct;
import com.ptg.payment.pojo.po.RpUserPayConfig;
import com.ptg.payment.pojo.vo.PayUserConfigQuery;
import com.ptg.payment.service.UserPayConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenbo
 * Date: 2017/10/27
 * Time: 16:16
 * Version:V1.0
 */

@Service
public class UserPayConfigServiceImpl implements UserPayConfigService {

    @Autowired
    private RpUserPayConfigCustomMapper configDao;

    @Override
    public Result<RpUserPayConfig> payListConfigs(Page page, PayUserConfigQuery query) {
        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("query",query);
        List<RpUserPayConfig> list = configDao.payListConfigs(map);
        long counts = configDao.countPayConfigs(map);
        Result<RpUserPayConfig> rs = new Result<>();
        rs.setRows(list);
        rs.setTotal(counts);
        return rs;
    }
}
