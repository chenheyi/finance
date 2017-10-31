package com.ptg.payment.service;

import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.vo.AccountQuery;
import com.ptg.payment.pojo.vo.RpAccountCustom;

/**
 * User: lienjiaa
 * Date: 2017/10/26
 * Time: 20:10
 * Version:V1.0
 */
public interface AccountService {
    Result<RpAccountCustom> listAccountItems(Page page, Order order, AccountQuery query);
}
