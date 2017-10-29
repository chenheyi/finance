package com.ptg.payment.dao;

import com.ptg.payment.pojo.po.RpAdmin;

import java.util.List;

/**
 * User: chenbo
 * Date: 2017/10/28
 * Time: 21:19
 * Version:V1.0
 */
public interface RpAdminMapper {

    List<RpAdmin> selectAllAdmin();

}
