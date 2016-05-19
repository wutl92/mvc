package com.wutl.mvc.dao.impl.system;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.wutl.mvc.bean.User;
import com.wutl.mvc.dao.BaseDaoImpl;
import com.wutl.mvc.dao.system.UserDao;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public User checkUser(User user) {
		User client = null;
		try {
			Query query = this.getSession()
					.createQuery("from User u where u.userName= ? and u.password = ?");
			query.setString(0, user.getUserName());
			query.setString(1, user.getPassword());
			List list = query.list();
			if(list.size()==1)
				client = (User) list.get(0);
		} catch (Exception e) {
			log.info("用户不存在！");
			e.printStackTrace();
			return null;
		}
		return client;
	}
}
