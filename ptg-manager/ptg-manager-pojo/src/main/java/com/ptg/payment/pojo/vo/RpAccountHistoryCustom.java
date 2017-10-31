package com.ptg.payment.pojo.vo;

import com.ptg.payment.pojo.po.RpAccountHistory;

import java.io.Serializable;

/**
 * User: lienjiaa
 * Date: 2017/10/27
 * Time: 21:55
 * Version:V1.0
 */
public class RpAccountHistoryCustom extends RpAccountHistory implements Serializable{
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
