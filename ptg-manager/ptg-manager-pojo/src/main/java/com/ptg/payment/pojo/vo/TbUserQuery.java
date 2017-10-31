package com.ptg.payment.pojo.vo;

/**
 * User: DHC
 * Date: 2017/10/23
 * Time: 10:13
 * Version:V1.0
 * 商品实体类查询类
 */
public class TbUserQuery {

    private String title;

    private Byte status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
