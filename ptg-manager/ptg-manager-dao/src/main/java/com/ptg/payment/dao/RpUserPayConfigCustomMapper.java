package com.ptg.payment.dao;

import com.ptg.payment.pojo.po.RpUserPayConfig;

import java.util.List;
import java.util.Map;

/**
 * User: chenbo
 * Date: 2017/10/27
 * Time: 16:28
 * Version:V1.0
 */
public interface RpUserPayConfigCustomMapper {
    List<RpUserPayConfig> payListConfigs(Map<String,Object> map);

    long countPayConfigs(Map<String,Object> map);
}
