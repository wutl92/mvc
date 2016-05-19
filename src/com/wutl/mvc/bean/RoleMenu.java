package com.wutl.mvc.bean;

public class RoleMenu {

	private Integer id;// 主键

	private Integer roleId;// 角色ID

	private Integer menuId;// 配置权限(菜单表)ID

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public RoleMenu(Integer roleId, Integer menuId) {
		super();
		this.roleId = roleId;
		this.menuId = menuId;
	}

	public RoleMenu() {

	}
}
