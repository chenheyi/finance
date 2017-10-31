package com.ptg.payment.service.impl;


import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.common.util.IDUtils;
import com.ptg.payment.dao.RpAccountMapper;
import com.ptg.payment.dao.TbUserMapper;
import com.ptg.payment.pojo.po.RpAccount;
import com.ptg.payment.pojo.po.RpUserInfo;
import com.ptg.payment.pojo.vo.TbUserCustom;
import com.ptg.payment.pojo.vo.TbUserQuery;
import com.ptg.payment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: DHC
 * Date: 2017/10/17
 * Time: 10:18
 * Version:V1.0
 */
@Service
public class UserServiceImpl implements UserService {

//    @Autowired
//    private TbItemMapper itemDao;
    @Autowired
    private TbUserMapper userDaoCustom;
    @Autowired
    private RpAccountMapper rpDaoCustom;
//    @Autowired
//    private TbItemDescMapper itemDescDao;

//    @Override
//    public TbItem getById(Long itemId) {
//        return itemDao.selectByPrimaryKey(itemId);
//    }itemId

//    @Override
//    public List<TbItem> listItems() {
//        //select * from tb_item; 问题：*  id,xxxxx
//        return itemDao.selectByExample(null);
//    }

    @Override
    public Result<TbUserCustom> listUsers(Page page, Order order, TbUserQuery query) {
        //
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);
        map.put("order", order);
        map.put("query",query);
        //通过itemDaoCustom查询出total，查询所有商品数量，没有附加条件
        long total = userDaoCustom.countItems(map);
        List<TbUserCustom> rows = userDaoCustom.listItemsByPage(map);
        for(TbUserCustom tc:rows){
            System.out.println("用户名:"+tc.getUserName()+"用户编号："+tc.getAccountNo()+"状态:"+tc.getStatus());
        }
        //通过itemDaoCustom查询出rows
        Result<TbUserCustom> rs = new Result<TbUserCustom>();
        rs.setTotal(total);
        rs.setRows(rows);
        return rs;
    }

//    @Override
//    public int updateItemsByIds(List<Long> ids) {
//        //创建商品的空对象
//        TbItem item = new TbItem();
//        item.setStatus((byte) 3);
//        //下面的三行只是准备查询的条件
//        TbItemExample example = new TbItemExample();
//        TbItemExample.Criteria criteria = example.createCriteria();
//        criteria.andIdIn(ids);
//        //真正的执行查询
//        return itemDao.updateByExampleSelective(item, example);
//    }

    //@Transactional注解后表示这是一个事务方法，事务方法不是越多越好，平常使用查询方法不需要添加此注解
     @Transactional
     @Override
   public int saveItem(RpUserInfo rpuserInfo, String desc) {
        //通过工具类获取到商品ID

        //tbItem传进来时已经携带了6个属性
         //通过工具类获取到商品ID
         Long itemId = IDUtils.getItemId();
         //tbItem传进来时已经携带了6个属性
         rpuserInfo.setId(itemId+"");
         rpuserInfo.setStatus("1");
         rpuserInfo.setCreateTime(new Date());

        //存商品
        int count = userDaoCustom.insert(rpuserInfo);
        //存商品描述表（商品的ID保持一致）
         RpAccount rpaccount = new RpAccount();
         rpaccount.setId(itemId+"");
         rpaccount.setAccountNo(rpuserInfo.getAccountNo());
         rpaccount.setCreateTime(new Date());
         rpaccount.setStatus("1");
         rpaccount.setUnbalance(BigDecimal.valueOf(0));
         rpaccount.setBalance(BigDecimal.valueOf(0));
         rpaccount.setCreateTime(new Date());
         rpaccount.setUserNo(rpuserInfo.getUserNo());
         rpaccount.setTodayExpend(BigDecimal.valueOf(0));
         rpaccount.setTodayIncome(BigDecimal.valueOf(0));
         rpaccount.setSettAmount(BigDecimal.valueOf(0));
         rpDaoCustom.insert(rpaccount);
        return count;
    }


}
