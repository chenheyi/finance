package com.ptg.payment.pojo.vo;

import com.ptg.payment.pojo.po.RpPayProduct;

/**
 * User: chenbo
 * Date: 2017/10/26
 * Time: 21:46
 * Version:V1.0
 */
public class RpPayProductCustom extends RpPayProduct {

    private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
