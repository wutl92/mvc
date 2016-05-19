/**
 * 
 */
package com.wutl.mvc.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wutl.mvc.bean.User;
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
@SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	private static final Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);
	
	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> clazz;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		/**
		 * 获取泛型类型
		 */
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Override
	public void save(Object entity) {
		if(Tools.isEmpty(entity)){
			log.info(clazz+"实体，保存失败！对象为Null");
			return;
		}
		getSession().save(entity);
		log.info(clazz+"实体，保存成功！");
	}

	@Override
	public void delete(Object entity) {
		if(Tools.isEmpty(entity)){
			log.info(clazz+"实体，删除失败！对象为Null");
			return;
		}
		getSession().delete(entity);
		log.info(clazz+"实体，删除成功！");
		
	}

	@Override
	public void update(Object entity) {
		if(Tools.isEmpty(entity)){
			log.info(clazz+"实体，修改失败！对象为Null");
			return;
		}
		getSession().update(entity);
		log.info(clazz+"实体，修改成功！");
	}

	@Override
	public List<T> findList(Condition condition) {
		List<T> list = new ArrayList<T>();
		//如果条件为空 查询所有
		Query query = getSession().createQuery("From " + clazz.getSimpleName());
		if(!Tools.isEmpty(condition)){
			Page page = condition.getPage();
			query.setFirstResult(page.getStart());
			query.setMaxResults(page.getEnd());
		}
		list = query.list();
		return list;
	}

	@Override
	public T get(String id) {
		Object object = getSession().get(clazz,new Integer(id));
		return (T) object;
	}
}
