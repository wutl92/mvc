/**
 * 
 */
package com.wutl.mvc.service;

import java.util.List;

import com.wutl.mvc.tool.Condition;

/**
 * <pre>
 * 名称: 
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public interface BaseService<T> {
	/**
	 * 保存
	 * @param entity
	 */
	public void save(T entity);
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(T entity);
	/**
	 * 修改
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * 根据条件查询
	 * @param condition
	 * @return
	 */
	public List<T> findList(Condition condition);
	
	public T  get(String id);
}
