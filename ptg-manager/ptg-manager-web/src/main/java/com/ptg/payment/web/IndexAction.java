package com.ptg.payment.web;

import com.ptg.payment.pojo.po.RpAdmin;
import com.ptg.payment.service.RpAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: chenbo
 * Date: 2017/10/24
 * Time: 23:07
 * Version:V1.0
 */

@Controller
@Scope("prototype")
/*@RequestMapping("indexAction")*/
public class IndexAction {

    @Autowired
    private RpAdminService ser;

    @RequestMapping("/")
    public String login(){
        //WEB-INF/jsp/是.jsp
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/check")
    @ResponseBody
    public String login(RpAdmin admin){
        return  ser.selectByRpAdmin(admin);
    }


   @RequestMapping("/{page}")
    public String page(@PathVariable String page){
        return page;
    }

}
