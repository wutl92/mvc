package com.wutl.mvc.bean;

public class Role  extends BaseInfo{

	private Integer id;// 主键

	private String roleName;// 角色名称

	private String roleDesc;// 角色描述

	private String isSupper;// 是否是超级系统管理角色：0表示“不是”，1表示“是”
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getIsSupper() {
		return isSupper;
	}

	public void setIsSupper(String isSupper) {
		this.isSupper = isSupper;
	}

	public Role(String roleName, String roleDesc, String isSupper) {
		super();
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.isSupper = isSupper;
	}

	public Role() {

	}
}
