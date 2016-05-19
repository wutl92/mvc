/**
 * 
 */
package com.wutl.mvc.service;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wutl.mvc.bean.Menu;
import com.wutl.mvc.bean.User;
import com.wutl.mvc.dao.BaseDao;
import com.wutl.mvc.tool.Condition;
import com.wutl.mvc.tool.Tools;

/**
 * <pre>
 * 名称: 
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public class BaseServiceImpl<T> implements BaseService<T> {

	private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);

	@Autowired
	private BaseDao<T> baseDao;


	@Override
	public void save(T entity) {
		baseDao.save(entity);
	}

	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public List<T> findList(Condition condition) {
		return baseDao.findList(condition);
	}

	@Override
	public T get(String id) {
		return baseDao.get(id);
	}
}
