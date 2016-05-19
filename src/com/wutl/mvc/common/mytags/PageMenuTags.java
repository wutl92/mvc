/**
 * 
 */
package com.wutl.mvc.common.mytags;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.wutl.mvc.common.system.MenuTree;
import com.wutl.mvc.common.system.UserManager;
import com.wutl.mvc.tool.Page;
import com.wutl.mvc.tool.Tools;

/**
 * <pre>
 * 名称: 页面菜单导航
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */
@SuppressWarnings("all")
public class PageMenuTags extends TagSupport{
	
	
	
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		count = 0;
		JspWriter out = this.pageContext.getOut();
		HttpSession session = this.pageContext.getSession();
		Map<String, Object> repository = UserManager.getPersonRepository(session);
		List<MenuTree> list = (List<MenuTree>) repository.get("menuTree");
		parseMenu(list,out);
		return super.doStartTag();
	}
	
	/**
	 * 解析菜单
	 * @param list
	 */
	private void parseMenu(List<MenuTree> list,JspWriter out)throws JspException {
		int c = 0;
		try {
			for (MenuTree menu : list) {
				out.print("<div id=\""+menu.getId()+"\"   title=\""+menu.getMenuName()+"\" data-options=\"iconCls:'"+menu.getImg()+"'\" style=\"overflow:auto;padding:10px;\"> ");
					List<MenuTree> children = menu.getChildren();
					if(children.size()>0){
						setInnerMenu(children,out,0,c);
					}
				out.print("</div>");
				c++;
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 设置选项卡里面的菜单
	 * @param children
	 */
	int count = 0;
	private void setInnerMenu(List<MenuTree> children,JspWriter out,int i,int c) throws Exception {
		String easyuitree ="";
		String name="";
		String id = "";
		if(i==0){
			easyuitree = "class=\"easyui-tree\"";
			id = "id = 'menuTree"+c+"'";
			name = "tt";
		}
		out.print("<ul "+id+" name = '"+name+"'  "+easyuitree+" >");
		out.newLine();
		for (MenuTree menuTree : children) {
			i++;
			String url = Tools.isEmpty(menuTree.getUrl())? "#":menuTree.getUrl();
			out.print("<li>");
			out.newLine();
			String node = "<span><a href='javascript:getUrl(\""+menuTree.getUrl()+"\")'>"+menuTree.getMenuName()+"</a></span>";
			out.print(node);
			if(menuTree.getChildren().size()>0){
				setInnerMenu(menuTree.getChildren(),out,i,0);
			}
			out.print("</li>");
			out.newLine();
		}
		count++;
		out.print("</ul>");
		out.newLine();
	}

	@Override
	public void release() {
		count = 0;
		super.release();
	}
	
}
