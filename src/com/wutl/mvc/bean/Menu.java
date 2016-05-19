/**
 * 
 */
package com.wutl.mvc.bean;

import java.util.Date;

/**
 * <pre>
 * 名称: 菜单
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public class Menu extends BaseInfo {

	private Integer id;// 菜单id，主键

	private String menuName;// 菜单名称

	private Integer menuParent;// 父级id

	private String url;// 菜单的链接地址

	private String action;// 菜单的action地址

	private Integer menuLevel;// 菜单等级(1,2,,,N)

	private Integer menuPriority;// 菜单优先级

	private String menuPath;// 菜单路径

	private String target;// 链接目标

	private Integer sort;// 排序(菜单中排列的位置)

	private String methodName;// 方法名称(点击事件触发方法)

	private String img;// 按钮的图片

	private Date createTime;// 数据创建时间

	private Integer menuType;// 菜单类型0菜单,1按钮

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getmenuParent() {
		return menuParent;
	}

	public void setmenuParent(Integer menuParent) {
		this.menuParent = menuParent;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public Integer getMenuPriority() {
		return menuPriority;
	}

	public void setMenuPriority(Integer menuPriority) {
		this.menuPriority = menuPriority;
	}

	public String getMenuPath() {
		return menuPath;
	}

	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}
	
}
