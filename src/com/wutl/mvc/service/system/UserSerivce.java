package com.wutl.mvc.service.system;

import javax.servlet.http.HttpSession;

import com.wutl.mvc.bean.User;
import com.wutl.mvc.common.sysenum.LoginStates;
import com.wutl.mvc.service.BaseService;

public interface UserSerivce extends BaseService<User>{
	/**
	 * 判断用户是否存在，或已经登录
	 * @param user
	 * @return
	 */
	LoginStates checkUser(User user,HttpSession session);
	
}
