package com.ptg.payment.service;

import com.ptg.payment.common.dto.Page;
import com.ptg.payment.common.dto.Result;
import com.ptg.payment.pojo.po.RpUserPayConfig;
import com.ptg.payment.pojo.vo.PayUserConfigQuery;

/**
 * User: chenbo
 * Date: 2017/10/27
 * Time: 12:00
 * Version:V1.0
 */
public interface UserPayConfigService {

    Result<RpUserPayConfig> payListConfigs(Page page, PayUserConfigQuery query);
}
