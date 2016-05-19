package com.wutl.mvc.dao.system;

import com.wutl.mvc.bean.User;
import com.wutl.mvc.dao.BaseDao;

public interface UserDao extends BaseDao<User> {
	
	/**
	 * 检查用户
	 */
	public User checkUser(User user);
}
