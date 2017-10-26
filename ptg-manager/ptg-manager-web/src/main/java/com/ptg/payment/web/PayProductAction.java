package com.ptg.payment.web;

import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpPayProduct;
import com.ptg.payment.pojo.vo.PayProductQuery;
import com.ptg.payment.service.PayProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: chenbo
 * Date: 2017/10/25
 * Time: 20:58
 * Version:V1.0
 */

@Controller
@Scope("prototype")
public class PayProductAction {
    @Autowired
    private PayProductService ser;


    @RequestMapping("/productInfo")
    @ResponseBody
    public Result<RpPayProduct> listProducts(Page page, PayProductQuery query) {
        return ser.listProducts(page,query);
    }

    @ResponseBody
    @RequestMapping(value = "/downProducts/batch",method = RequestMethod.POST)
    public int downProductStatusByIds(@RequestParam("ids[]") List<String> ids){
        return ser.downProductStatusByIds(ids);
    }

    @ResponseBody
    @RequestMapping(value = "/upProducts/batch",method = RequestMethod.POST)
    public int upProductStatusByIds(@RequestParam("ids[]") List<String> ids){
        return ser.upProductStatusByIds(ids);
    }


}
