/**
 * 
 */
package com.wutl.mvc.controller.system;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <pre>
 * 名称: 系统控制器
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */
@RequestMapping("home")
@Controller
public class SystemController {
	
	@RequestMapping(params="go")
	public ModelAndView goHome(HttpSession session){
		return new ModelAndView("home/index");
	}
}
