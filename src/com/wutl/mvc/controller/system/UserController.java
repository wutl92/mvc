/**
 * 
 */
package com.wutl.mvc.controller.system;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wutl.mvc.bean.User;
import com.wutl.mvc.service.system.UserSerivce;
import com.wutl.mvc.tool.Condition;
import com.wutl.mvc.tool.Page;
import com.wutl.mvc.tool.Tools;

/**
 * <pre>
 * 名称: 
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserSerivce userService;

	@RequestMapping(params = "doAdd")
	public void doAdd(User user,HttpServletResponse response) {
		
		userService.save(user);
		try {
			response.getWriter().write("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd() {
		return new ModelAndView("system/user/user_add");
	}

	@RequestMapping(params = "doUpdate")
	public void doUpdate(User user) {
		if(Tools.isEmpty(user.getId())){
			log.debug("user'id 为Null活着\"\"字符串");
			return;
		}
		userService.update(user);
	}

	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate() {
		return new ModelAndView("");
	}

	@RequestMapping(params = "delUser")
	@ResponseBody
	public void doDelete(String ids) {
		if(Tools.isEmpty(ids)){
			log.debug("user'id 为Null活着\"\"字符串");
			return;
		}
		String[] idArr = Tools.splitStringByOp(ids, ",");
		for (String id : idArr) {
			User user = userService.get(id);
			userService.delete(user);
		}
	}

	@RequestMapping(params = "datagrid")
	@ResponseBody
	public List<User> getDatagrid(Page page) {
		Condition con = new Condition();
		con.setPage(page);
		List<User> list = userService.findList(con);
		return list;
	}
	@RequestMapping(params = "list")
	public ModelAndView goList(){
		return new ModelAndView("system/user/user_list");
	}
}
