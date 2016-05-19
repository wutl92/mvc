/**
 * 
 */
package com.wutl.mvc.service.impl.system;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wutl.mvc.bean.User;
import com.wutl.mvc.common.sysenum.LoginStates;
import com.wutl.mvc.common.system.UserManager;
import com.wutl.mvc.dao.system.UserDao;
import com.wutl.mvc.service.BaseServiceImpl;
import com.wutl.mvc.service.system.UserSerivce;
import com.wutl.mvc.tool.Tools;

/**
 * <pre>
 * 名称: 
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserSerivce  {

		
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public LoginStates checkUser(User user,HttpSession session) {
		User client = userDao.checkUser(user);
		if(Tools.isEmpty(client))
			return LoginStates.noUser;
		else{
			User onlineUser = UserManager.getOnlineUsers().get(session.getId());
			if(Tools.isEmpty(onlineUser)){
				UserManager.getOnlineUsers().put(session.getId(),client);
			
				return LoginStates.sucess;
			}
			else{
				return LoginStates.inUser;
			}
		}
	}
	
}
