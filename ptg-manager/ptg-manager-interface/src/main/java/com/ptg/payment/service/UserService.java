package com.ptg.payment.service;


import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpUserInfo;
import com.ptg.payment.pojo.vo.TbUserCustom;
import com.ptg.payment.pojo.vo.TbUserQuery;

/**
 * User: DHC
 * Date: 2017/10/17
 * Time: 10:16
 * Version:V1.0
 * 商品实体类的业务逻辑层接口
 */
public interface UserService {
    /**
     * 按主键查询指定商品
     * @param itemId
     * @return
     */
   // TbItem getById(Long itemId);

    /**
     * 不带分页的查询所有商品
     * @return
     */
    //List<TbItem> listItems();

    /**
     * 带分页的查询所有用户
     * @return
     */
    Result<TbUserCustom> listUsers(Page page, Order order, TbUserQuery query);

    /**
     * 通过商品编号批量修改商品
     * @param ids
     * @return
     */
   // int updateItemsByIds(List<Long> ids);
    /**
     * 保存商品和商品描述
     * @param tbItem
     * @param desc
     * @return
     */
    int saveItem(RpUserInfo rpuserInfo, String desc);
}
