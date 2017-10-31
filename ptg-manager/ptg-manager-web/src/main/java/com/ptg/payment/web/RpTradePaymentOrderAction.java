package com.ptg.payment.web;


import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpTradePaymentOrder;
import com.ptg.payment.pojo.vo.RpTradePaymentOrderQuery;
import com.ptg.payment.service.RpTradePaymentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: zhangpeng
 * Date: 2017/10/25
 * Time: 9:39
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class RpTradePaymentOrderAction {
    @Autowired
    private RpTradePaymentOrderService rpTradePaymentOrderService;
    @RequestMapping( "/order")
    @ResponseBody
    public Result<RpTradePaymentOrder> findOrderByPage(Page page, Order order, RpTradePaymentOrderQuery query){
        return  rpTradePaymentOrderService.findOrderByPage(page,order,query);
    }
}
