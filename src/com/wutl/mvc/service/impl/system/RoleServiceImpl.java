package com.wutl.mvc.service.impl.system;

import com.wutl.mvc.bean.Role;
import com.wutl.mvc.dao.system.RoleDao;
import com.wutl.mvc.service.BaseServiceImpl;
import com.wutl.mvc.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Autowired
    private RoleDao roleDao;

}
