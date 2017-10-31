package com.ptg.payment.web;

import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.vo.AccountQuery;
import com.ptg.payment.pojo.vo.RpAccountCustom;
import com.ptg.payment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: lienjiaa
 * Date: 2017/10/26
 * Time: 19:57
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class AccountAction {
    @Autowired
    private AccountService accountService;
    @ResponseBody
    @RequestMapping("/accountInfo")
    public Result<RpAccountCustom> listAccountItems(Page page, Order order, AccountQuery query){
        return accountService.listAccountItems(page,order,query);
    }
}
