package com.ptg.payment.dao;

import com.ptg.payment.pojo.vo.RpAccountHistoryCustom;

import java.util.List;
import java.util.Map;

public interface RpAccountHistoryCustomMapper {
    long countItems(Map<String, Object> map);
    List<RpAccountHistoryCustom> listItemsByPage(Map<String, Object> map);
}