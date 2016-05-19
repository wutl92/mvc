/**
 * 
 */
package com.wutl.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wutl.mvc.bean.User;
import com.wutl.mvc.common.system.UserManager;
import com.wutl.mvc.tool.Tools;

/**
 * <pre>
 * 名称: 登录拦截器
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public class LoginInterceptor extends HandlerInterceptorAdapter  {

	public static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginInterceptor.afterCompletion()");
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor.afterConcurrentHandlingStarted()");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor.postHandle()");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getRequestURI();
		HttpSession session = request.getSession();
		log.info("连接地址："+path);
		if(path.indexOf("login.do")>=0){
			return true;
		}else{
			User onlineUser = UserManager.getOnlineUsers().get(session.getId());
			boolean flag = Tools.isEmpty(onlineUser)? false : true;
			if(!flag){
				response.sendRedirect("login.do?go");
				System.out.println(response);
			}
			return flag;
		}
	}
	
}
