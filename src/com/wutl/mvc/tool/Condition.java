/**
 * 
 */
package com.wutl.mvc.tool;

/**
 * <pre>
 * 名称: 查询条件类
 * 功能: 提供分页对象
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public class Condition {
	private Page pages;//分页对象

	public Page getPages() {
		return pages;
	}
	
	public void setPages(Page pages) {
		this.pages = pages;
	}
}
