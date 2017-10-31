package com.ptg.payment.web;


import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpUserInfo;
import com.ptg.payment.pojo.vo.TbUserCustom;
import com.ptg.payment.pojo.vo.TbUserQuery;
import com.ptg.payment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: DHC
 * Date: 2017/10/17
 * Time: 10:08
 * Version:V1.0
 * 商品的控制层代码
 */
@Controller
@Scope("prototype")
public class UserAction {
    @Autowired
    private UserService userService;

//    @ResponseBody
//    @RequestMapping(value = "/item/{itemId}",method = RequestMethod.GET)
//    public TbItem getById(@PathVariable Long itemId){
//        return itemService.getById(itemId);
//    }

//    @ResponseBody
//    @RequestMapping("/items")
//    public List<TbItem> listItems(){
//        return itemService.listItems();
//    }

    @ResponseBody
    @RequestMapping("/users")
    public Result<TbUserCustom> listItems(Page page, Order order, TbUserQuery query){
        return userService.listUsers(page,order,query);
    }

//    @ResponseBody
//    @RequestMapping(value = "/items/batch",method = RequestMethod.POST)
//    public int updateItemsByIds(@RequestParam("ids[]") List<Long> ids){
//        return itemService.updateItemsByIds(ids);
//    }
//    @RequestMapping(value="/item",method=RequestMethod.POST)
//    @ResponseBody
//    public int saveItem(TbItem tbItem,String desc){
//        return itemService.saveItem(tbItem,desc);
//    }
    /**
     * 保存新商品
     * @param tbItem 为了对应除商品描述以外其他字段
     * @param content 为了对应商品描述
     * @return 受到影响的行数
     */
    @ResponseBody
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public int saveItem(RpUserInfo rpuserInfo, String content){
        return userService.saveItem(rpuserInfo,content);
    }

}
