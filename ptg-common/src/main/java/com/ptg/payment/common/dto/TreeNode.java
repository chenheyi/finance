package com.ptg.payment.common.dto;

/**
 * User: chenbo
 * Date: 2017/10/30
 * Time: 11:31
 * Version:V1.0
 */
public class TreeNode {
    private Long id;
    private String state;
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
