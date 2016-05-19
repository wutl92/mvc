/**
 * 
 */
package com.wutl.mvc.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wutl.mvc.bean.User;
import com.wutl.mvc.common.sysenum.LoginStates;
import com.wutl.mvc.common.system.UserManager;
import com.wutl.mvc.service.system.MenuService;
import com.wutl.mvc.service.system.UserSerivce;
import com.wutl.mvc.tool.OutMsgUtil;
import com.wutl.mvc.tool.Tools;

/**
 * <pre>
 * 名称: 登陆控制器
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */
@Controller
@RequestMapping("/login")
@SuppressWarnings("all")
public class LoginController {
	
	@Autowired
	private UserSerivce userService;
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(params="check")
	public void checkUser(User user,HttpServletResponse response,HttpSession session){
		LoginStates check = userService.checkUser(user,session);
		String message = "";
		if(LoginStates.noUser.equals(check)){
			message = "用户名或密码错误！";
		}else if(LoginStates.sucess.equals(check)) {
			message = "true";
			UserManager.addPersonData(session, "menuTree", menuService.getPersonMenu());
		}else if(LoginStates.inUser.equals(check)){
			message = "用户已经在线，请勿重新登录！";
		}
		OutMsgUtil.outMessage(message, response);
	}
	@RequestMapping(params="go")
	public ModelAndView goLogin(){
		return new ModelAndView("system/login");
	}
}
