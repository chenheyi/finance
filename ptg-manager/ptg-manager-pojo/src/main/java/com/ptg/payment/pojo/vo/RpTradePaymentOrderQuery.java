package com.ptg.payment.pojo.vo;


/**
 * User: zhangpeng
 * Date: 2017/10/25
 * Time: 10:38
 * Version:V1.0
 */
public class RpTradePaymentOrderQuery {
    private String merchantNo;
   private String merchantName;
   private String merchantOrderNo;
//    //下单时间
//  private Date orderDate;
//    //到期时间
  // private Date expireTime;
    private String payWayName;
   private String payTypeName;
   private String fundIntoType;
   private  String Status;

   public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

   public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

/* public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }*/

   /* public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }*/

    public String getPayWayName() {
        return payWayName;
    }

    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName;
    }

  public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public String getFundIntoType() {
        return fundIntoType;
    }

    public void setFundIntoType(String fundIntoType) {
        this.fundIntoType = fundIntoType;
    }
}
