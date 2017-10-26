package com.ptg.payment.common.dto;

/**
 * User: chenbo
 * Date: 2017/10/24
 * Time: 23:13
 * Version:V1.0
 */
public class Admin {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
