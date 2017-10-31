package com.ptg.payment.dao;

import com.ptg.payment.pojo.po.RpSettRecord;
import java.util.List;

import java.util.Map;

public interface RpSettRecordCustomMapper {
    long countItems(Map<String, Object> map);
    List<RpSettRecord> listItemsByPage(Map<String, Object> map);
}