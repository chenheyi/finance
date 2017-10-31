package com.ptg.payment.web;

import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpSettRecord;
import com.ptg.payment.pojo.vo.SettRecordQuery;
import com.ptg.payment.service.SettRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * User: lienjiaa
 * Date: 2017/10/25
 * Time: 19:53
 * Version:V1.0
 */
@Controller
@Scope("prototype")
public class SettRecordAction {
    @Autowired
    private SettRecordService settRecordService;
    @ResponseBody
    @RequestMapping("/items")
    public Result<RpSettRecord> listSRItems(Page page, Order order, SettRecordQuery query){
        return settRecordService.listSRItems(page,order,query);
    }
    @RequestMapping("/viewInfo")
    public String findById(@RequestParam("id") String id, Model model){
       RpSettRecord rsr = settRecordService.findById(id);
       model.addAttribute("rsr",rsr);
        return "showInfo";
    }
}
