package com.ptg.payment.service;

import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.vo.AccountQuery;
import com.ptg.payment.pojo.vo.RpAccountHistoryCustom;

/**
 * User: lienjiaa
 * Date: 2017/10/27
 * Time: 22:01
 * Version:V1.0
 */
public interface AccountHistoryService {
    Result<RpAccountHistoryCustom> listAHItems(Page page, Order order, AccountQuery query);
}
