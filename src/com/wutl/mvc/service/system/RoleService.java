package com.wutl.mvc.service.system;

import com.wutl.mvc.bean.Role;
import com.wutl.mvc.service.BaseService;
import com.wutl.mvc.tool.Condition;

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

public interface RoleService  extends BaseService<Role> {

    List<Role> getRoleByLimit(Condition condition);

    long getRoleCount();
}
