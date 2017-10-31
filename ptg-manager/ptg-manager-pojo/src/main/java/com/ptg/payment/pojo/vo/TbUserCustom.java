package com.ptg.payment.pojo.vo;

import com.ptg.payment.pojo.po.RpUserInfo;

/**
 * User: DHC
 * Date: 2017/10/19
 * Time: 14:00
 * Version:V1.0
 * 商品对应于页面的实体类
 */
public class TbUserCustom extends RpUserInfo {
    //显示的是分类的名称
    private String acctno;

    public String getAcctNo() {
        return acctno;
    }

    public void setAcctNo(String acctno) {
        this.acctno = acctno;
    }
}
