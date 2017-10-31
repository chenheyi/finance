package com.ptg.payment.dao;

import com.ptg.payment.pojo.vo.RpAccountCustom;

import java.util.List;
import java.util.Map;

public interface RpAccountCustomMapper {
    long countItems(Map<String, Object> map);
    List<RpAccountCustom> listItemsByPage(Map<String, Object> map);
}