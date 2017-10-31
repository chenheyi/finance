package com.ptg.payment.web;


import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpTradePaymentRecord;
import com.ptg.payment.pojo.vo.RpTradePaymentOrderQuery;
import com.ptg.payment.service.RpTradePaymentRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: zhangpeng
 * Date: 2017/10/25
 * Time: 20:52
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class RpTradePaymentRecordAction {
    @Autowired
    private RpTradePaymentRecordService rpTradePaymentRecordService;

    @RequestMapping( "/record")
    @ResponseBody
    public Result<RpTradePaymentRecord> findRecordByPage(Page page, Order order, RpTradePaymentOrderQuery query){
        return  rpTradePaymentRecordService.findRecordByPage(page,order,query);
    }
}
