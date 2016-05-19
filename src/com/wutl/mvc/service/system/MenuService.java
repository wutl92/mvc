package com.wutl.mvc.service.system;

import java.util.List;

import com.wutl.mvc.bean.Menu;
import com.wutl.mvc.common.system.MenuTree;
import com.wutl.mvc.service.BaseService;

public interface MenuService extends BaseService<Menu> {
	/**
	 * 获得个人菜单
	 * @return
	 */
	public List<MenuTree> getPersonMenu();
}
