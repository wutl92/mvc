/**
 * 
 */
package com.wutl.mvc.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wutl.mvc.bean.Menu;
import com.wutl.mvc.common.system.MenuTree;
import com.wutl.mvc.dao.system.MenuDao;
import com.wutl.mvc.service.BaseServiceImpl;
import com.wutl.mvc.service.system.MenuService;

/**
 * <pre>
 * 名称: 
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Override
	public List<MenuTree> getPersonMenu() {
		return menuDao.getPersonMenu();
	}
	
}
