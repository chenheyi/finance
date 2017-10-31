package com.ptg.payment.web;

import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.vo.AccountQuery;
import com.ptg.payment.pojo.vo.RpAccountHistoryCustom;
import com.ptg.payment.service.AccountHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: lienjiaa
 * Date: 2017/10/27
 * Time: 21:53
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class AccountHistoryAction {
    @Autowired
    private AccountHistoryService accountHistoryService;
    @ResponseBody
    @RequestMapping("/accountHistory")
    public Result<RpAccountHistoryCustom> listAHItems(Page page, Order order , AccountQuery query){
        return accountHistoryService.listAHItems(page,order,query);
    }
}
