/**
 * 
 */
package com.wutl.mvc.dao.system;

import java.util.List;

import com.wutl.mvc.bean.Menu;
import com.wutl.mvc.common.system.MenuTree;
import com.wutl.mvc.dao.BaseDao;

/**
 * <pre>
 * 名称: 
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public interface MenuDao extends BaseDao<Menu> {
	/**
	 * 获得个人菜单
	 * @return
	 */
	public List<MenuTree> getPersonMenu();
}
