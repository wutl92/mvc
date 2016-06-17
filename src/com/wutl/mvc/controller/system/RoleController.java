package com.wutl.mvc.controller.system;

import com.wutl.mvc.bean.Role;
import com.wutl.mvc.service.system.RoleService;
import com.wutl.mvc.tool.Condition;
import com.wutl.mvc.tool.DatagridJson;
import com.wutl.mvc.tool.Page;
import com.wutl.mvc.tool.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    
    private static final Logger log = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;

    /**
     * 增加用户
     * @param id
     */
    @RequestMapping(params = "add")
    public void addRole(String id){
        if(Tools.isEmpty(id))
            return;
        Role role = roleService.get(id);
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
    public DatagridJson datagrid(int page,int rows){
        Condition condition = new Condition();
        condition.setPage(new Page(page,rows));
        DatagridJson<Role> data = new DatagridJson<Role>();
        List<Role> list = roleService.getRoleByLimit(condition);
        long count = roleService.getRoleCount();
        data.setRows(list);
        data.setTotal(count);
        return new DatagridJson();
    }
}
