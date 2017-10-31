package com.ptg.payment.dao;

import com.ptg.payment.pojo.po.RpUserInfo;
import com.ptg.payment.pojo.vo.TbUserCustom;

import java.util.List;
import java.util.Map;

/**
 * User: DHC
 * Date: 2017/10/19
 * Time: 9:37
 * Version:V1.0
 * 自定义TbItemMapper的DAO层接口
 */
public interface TbUserMapper {
    /**
     * 查询所有商品的总记录数
     * @return
     */
    long countItems(Map<String, Object> map);

    /**
     * 分页查询出商品集合
     * @return
     */
    List<TbUserCustom> listItemsByPage(Map<String, Object> map);

    int insert(RpUserInfo record);
}
