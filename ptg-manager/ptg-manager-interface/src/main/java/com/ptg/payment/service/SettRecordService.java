package com.ptg.payment.service;

import com.ptg.payment.common.dto.Order;
import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpSettRecord;
import com.ptg.payment.pojo.vo.SettRecordQuery;

/**
 * User: lienjiaa
 * Date: 2017/10/25
 * Time: 20:06
 * Version:V1.0
 */
public interface SettRecordService {
    Result<RpSettRecord> listSRItems(Page page, Order order, SettRecordQuery query);

    RpSettRecord findById(String id);
}
