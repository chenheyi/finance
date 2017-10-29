package com.ptg.payment.web;

import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpUserPayConfig;
import com.ptg.payment.pojo.vo.PayUserConfigQuery;
import com.ptg.payment.service.UserPayConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: chenbo
 * Date: 2017/10/27
 * Time: 11:54
 * Version:V1.0
 */
@Controller
public class UserPayConfigAction {

    @Autowired
    private UserPayConfigService ser;

    @RequestMapping("/ListUserPayConfig")
    @ResponseBody
    public Result<RpUserPayConfig> payListConfigs(Page page, PayUserConfigQuery query) {
        return ser.payListConfigs(page,query);
    }

   /* @ResponseBody
    @RequestMapping(value = "/downProducts/batch",method = RequestMethod.POST)
    public int downProductStatusByIds(@RequestParam("ids[]") List<String> ids){
        return ser.downProductStatusByIds(ids);
    }

    @ResponseBody
    @RequestMapping(value = "/upProducts/batch",method = RequestMethod.POST)
    public int upProductStatusByIds(@RequestParam("ids[]") List<String> ids){
        return ser.upProductStatusByIds(ids);
    }
*/

}

