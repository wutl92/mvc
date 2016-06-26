package com.wutl.mvc.service.impl.system;

import com.wutl.mvc.bean.Role;
import com.wutl.mvc.dao.system.RoleDao;
import com.wutl.mvc.service.BaseServiceImpl;
import com.wutl.mvc.service.system.RoleService;
import com.wutl.mvc.tool.Condition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * 名称:
 * 功能:
 * 作者: wutl
 * Copyright: 杭州市威灿科技 (c) 2016
 * 版本 1.0[原始架构]
 * </pre>
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    private static final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getRoleByLimit(Condition condition) {
        System.out.println(".............");
        log.info(condition.getPage()+"");
        List<Role> list = roleDao.findList(condition);
        return list;
    }

    @Override
    public long getRoleCount() {
        long  count  = roleDao.getCount();
        return count;
    }
}
