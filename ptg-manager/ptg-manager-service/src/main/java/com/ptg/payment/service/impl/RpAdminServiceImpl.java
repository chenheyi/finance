package com.ptg.payment.service.impl;

import com.ptg.payment.dao.RpAdminMapper;
import com.ptg.payment.pojo.po.RpAdmin;
import com.ptg.payment.service.RpAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: chenbo
 * Date: 2017/10/29
 * Time: 16:02
 * Version:V1.0
 */
@Service
public class RpAdminServiceImpl implements RpAdminService{

    @Autowired
    private RpAdminMapper adminDao;

    @Override
    public String  selectByRpAdmin(RpAdmin admin) {
        List<RpAdmin> list = adminDao.selectAllAdmin();
        for (int i = 0;i<list.size();i++) {
            RpAdmin ra =  list.get(i);
            if(admin.getaName().equals(ra.getaName())) {
                if(admin.getaPassword().equals(ra.getaPassword())) {
                    return "0";
                }
            }
        }
        return "1";
    }
}
