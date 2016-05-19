/**
 * 
 */
package com.wutl.mvc.dao.impl.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wutl.mvc.bean.Menu;
import com.wutl.mvc.common.system.MenuTree;
import com.wutl.mvc.dao.BaseDaoImpl;
import com.wutl.mvc.dao.system.MenuDao;

/**
 * <pre>
 * 名称: 
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */
@SuppressWarnings("all")
@Service
public class MenuDaoImpl extends BaseDaoImpl<Menu> implements MenuDao {
	
	@Override
	public List<MenuTree> getPersonMenu() {
		return getMenuTree();
	}
	/**
	 * 获得个人菜单列表
	 * @return
	 */
	public List<MenuTree> getMenuTree(){
		List<Menu> list = this.getSession().createQuery("from Menu m where m.menuParent is null ").list();
		List<MenuTree> treeList = setMenuTree(list);
		return treeList;
	}
	
	private  List<MenuTree> setMenuChildren(MenuTree mtree) {
		List<Menu> list = this.getSession().createQuery("from Menu m where m.menuParent = "+mtree.getId()).list();
		List<MenuTree> treeList = setMenuTree(list);
		return treeList;
	}

	private List<MenuTree> setMenuTree(List<Menu> list) {
		List<MenuTree> treeList = new ArrayList<MenuTree>();
		for (Menu son : list) {
			MenuTree tree = toTree(son);
			tree.setChildren(setMenuChildren(tree));
			treeList.add(tree);
		}
		return treeList;
	}
	
	/**
	 * 数据库结构转化成树对象
	 * @param menu
	 * @return
	 */
	private MenuTree toTree(Menu menu) {
		MenuTree tree = new MenuTree();
		tree.setId(menu.getId());
		tree.setUrl(menu.getUrl());
		tree.setImg(menu.getImg());
		tree.setMenuLevel(menu.getMenuLevel());
		tree.setMenuName(menu.getMenuName());
		tree.setMenuType(menu.getMenuType());
		tree.setMethodName(menu.getMethodName());
		return tree;
	}
}
