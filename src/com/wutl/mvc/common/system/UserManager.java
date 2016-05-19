/**
 * 
 */
package com.wutl.mvc.common.system;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wutl.mvc.bean.User;
import com.wutl.mvc.tool.Tools;

/**
 * <pre>
 * 名称: 在线用户管理
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public class UserManager {
	
	private static final Logger log = LoggerFactory.getLogger(UserManager.class);
	
	/** 个人相关信息存储 */
	public static Map<String,Map<String,Object>> dataRepository = new HashMap<String,Map<String,Object>>();
	
	private static UserManager userManager;
	
	private UserManager(){}
	
	private static Map<String, User> onlineUsers = new HashMap<String,User>();
	
	public static synchronized UserManager getInstence(){
		if(Tools.isEmpty(userManager)){
			userManager = new UserManager();
		}
		return userManager;
	}

	public static Map<String, User> getOnlineUsers() {
		return onlineUsers;
	}
	
	public static void setOnlineUsers(Map<String, User> onlineUsers) {
		UserManager.onlineUsers = onlineUsers;
	} 
	
	public void put(String sessionId,User user){
		onlineUsers.put(sessionId, user);
		log.info(user+"实体保存在用户管理当中");
	}
	
	public User getUser(String sessionId){
		return onlineUsers.get(sessionId);
	}
	
	public boolean removeUser(String sessionId){
		if(Tools.isEmpty(sessionId)){
			return false;
		}else{
			User remove = onlineUsers.remove(sessionId);
			log.info("session如果存在，则移除成功！");
			return remove == null ? true : false;
		}
	}
	/**
	 * 初始化个人在线数据仓库
	 * @param session
	 */
	public static Map<String, Object> getPersonRepository(HttpSession session){
		if(dataRepository.get(session.getId())==null){
			dataRepository.put(session.getId(), new HashMap<String, Object>());
			log.info("初始化个人数据仓库。");
		}
		return dataRepository.get(session.getId());
	}
	/**
	 * 存放个人数据
	 * @param session
	 * @param key
	 * @param object
	 */
	public static void addPersonData(HttpSession session , String key , Object value){
		Map<String, Object> repository = getPersonRepository(session);
		repository.put(key, value);
		log.info(session.getId()+":个人数据存放成功。");
	}
}
