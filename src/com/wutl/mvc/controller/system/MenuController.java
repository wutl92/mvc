/**
 * 
 */
package com.wutl.mvc.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.wutl.mvc.common.system.MenuTree;
import com.wutl.mvc.service.system.MenuService;

/**
 * <pre>
 * 名称: 菜单控制
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(params="getMenu")
	@ResponseBody
	public List<MenuTree> getTree(){
		List<MenuTree> personMenu = menuService.getPersonMenu();
		return personMenu;
	}

}
