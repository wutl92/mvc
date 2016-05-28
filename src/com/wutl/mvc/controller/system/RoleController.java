package com.wutl.mvc.controller.system;

import com.wutl.mvc.bean.Role;
import com.wutl.mvc.service.system.RoleService;
import com.wutl.mvc.tool.Condition;
import com.wutl.mvc.tool.Page;
import com.wutl.mvc.tool.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 增加用户
     * @param id
     */
    @RequestMapping(params = "doAdd")
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
    @RequestMapping(params = "go")
    public ModelAndView goRole(){
        System.out.println(".............");
        return new ModelAndView("system/role/role_ui");
    }

    @RequestMapping(params = "list")
    public ModelAndView roleList(){
        return new ModelAndView("system/role/role_list");
    }

    @RequestMapping(params = "datagrid")
    @ResponseBody
    public List<Role> datagrid(Page page,Role role,Condition condition){
        condition.setPages(page);
        List<Role> list = new ArrayList<Role>();
        list =  roleService.findList(condition);
        return list;
    }
}
