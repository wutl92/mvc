package com.wutl.mvc.bean;

public class UserRole {

	private Integer id;// 主键

	private Integer roleId;// 角色ID

	private Integer userId;// 配置权限(菜单表)ID

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public UserRole(Integer roleId, Integer userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}

	public UserRole() {

	}
}
