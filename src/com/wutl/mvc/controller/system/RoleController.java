package com.wutl.mvc.controller.system;

import com.wutl.mvc.bean.Role;
import com.wutl.mvc.service.system.RoleService;
import com.wutl.mvc.tool.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * 名称:
 * 功能:
 * 作者: wutl
 * Copyright: 杭州市威灿科技 (c) 2016
 * 版本 1.0[原始架构]
 * </pre>
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(params = "add")
    public void addRole(Role role){
        roleService.save(role);
    }

    @RequestMapping(params = "del")
    public String deleteRole(String id){
        Role role = roleService.get(id);
        if(Tools.isEmpty(role)){
            return "false";
        }else{
            roleService.delete(role);
            return "true";
        }
    }


}
