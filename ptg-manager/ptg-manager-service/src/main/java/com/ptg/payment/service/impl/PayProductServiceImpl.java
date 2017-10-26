package com.ptg.payment.service.impl;

import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.dao.RpPayProductCustomMapper;
import com.ptg.payment.dao.RpPayProductMapper;
import com.ptg.payment.pojo.po.RpPayProduct;
import com.ptg.payment.pojo.po.RpPayProductExample;
import com.ptg.payment.pojo.vo.PayProductQuery;
import com.ptg.payment.service.PayProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: chenbo
 * Date: 2017/10/25
 * Time: 21:06
 * Version:V1.0
 */

@Service
public class PayProductServiceImpl implements PayProductService {

    @Autowired
    private RpPayProductMapper payDao;
    @Autowired
    private RpPayProductCustomMapper customDao;


    @Override
    public Result<RpPayProduct> listProducts(Page page, PayProductQuery query) {

        Map<String, Object> map = new HashMap<>();
        map.put("page", page);
        map.put("query",query);
        List<RpPayProduct> list = customDao.listPayProducts(map);
        long counts = customDao.countPayProducts(map);
        Result<RpPayProduct> rs = new Result<>();
        rs.setRows(list);
        rs.setTotal(counts);
        return rs;
    }


    @Override
    public int downProductStatusByIds(List<String> ids) {
        //创建商品的空对象
        RpPayProduct product = new RpPayProduct();
        product.setStatus("否");
        //下面的三行只是准备查询的条件
        RpPayProductExample example = new RpPayProductExample();
        RpPayProductExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        //真正的执行查询
        return payDao.updateByExampleSelective(product, example);
    }

    @Override
    public int upProductStatusByIds(List<String> ids) {
        RpPayProduct product = new RpPayProduct();
        product.setStatus("是");
        //下面的三行只是准备查询的条件
        RpPayProductExample example = new RpPayProductExample();
        RpPayProductExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        //真正的执行查询
        return payDao.updateByExampleSelective(product, example);
    }
}
