/**
 * 
 */
package com.wutl.mvc.common.system;

import java.util.List;

/**
 * <pre>
 * 名称: 菜单树结构
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public class MenuTree {
	private Integer id;
	private String MenuTreeName;// 菜单名称
	private String url;// 菜单的链接地址
	private Integer MenuTreeLevel;// 菜单等级(1,2,,,N)
	private String methodName;// 方法名称(点击事件触发方法)
	private String img;// 按钮的图片
	private Integer MenuTreeType;// 菜单类型0菜单,1按钮 2链接
	private List<MenuTree> children;//子类菜单
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuName() {
		return MenuTreeName;
	}
	public void setMenuName(String MenuTreeName) {
		this.MenuTreeName = MenuTreeName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getMenuLevel() {
		return MenuTreeLevel;
	}
	public void setMenuLevel(Integer MenuTreeLevel) {
		this.MenuTreeLevel = MenuTreeLevel;
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
	public Integer getMenuType() {
		return MenuTreeType;
	}
	public void setMenuType(Integer MenuTreeType) {
		this.MenuTreeType = MenuTreeType;
	}
	public List<MenuTree> getChildren() {
		return children;
	}
	public void setChildren(List<MenuTree> children) {
		this.children = children;
	}
	
}
