/**
 * 
 */
package com.wutl.mvc.tool;

/**
 * <pre>
 * 名称: 分页对象
 * 功能: 
 * 作者: wutl
 * Copyright: 杭州市威灿科技 (c) 2016
 * 版本 1.0[原始架构]
 * </pre>
 */

public class Page {
	/**
	 * 当前页数
	 */
	private int page;
	/**
	 * 总记录数
	 */
	private int totals;
	/**
	 * 开始数
	 */
	private int start;
	/**
	 * 结束
	 */
	private int end;
	/**
	 * 页面大小
	 */
	private int rows;
	/**
	 * 总页数
	 */
	private int totalPage;
	public int getpage() {
		return page;
	}
	public void setpage(int page) {
		this.page = page;
	}
	public int gettotals() {
		return totals;
	}
	public void settotals(int totals) {
		this.totals = totals;
	}
	public int getStart() {
		this.start = (page-1)*10;
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		end = this.start + rows;
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getrows() {
		return rows;
	}
	public void setrows(int rows) {
		this.rows = rows;
	}
	public int getTotalPage() {
		totalPage = totals / rows;
		if(totals % rows > 0)
			totalPage+=1;
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
