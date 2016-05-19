/**
 * 
 */
package com.wutl.mvc.common.mytags;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.wutl.mvc.tool.Tools;

/**
 * <pre>
 * 名称: 页面公共文件引入
 * 功能: 引入静态文件
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public class PageScriptTag extends TagSupport {
	
	private String include;
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = this.pageContext.getOut();//获取页面输出流对象
		if(Tools.isEmpty(include)){
			return EVAL_PAGE;
		}else{
			Map<String, List<String>> includeFile = Tools.getIncludeFile(include);
			if(includeFile.isEmpty()){
				return EVAL_PAGE;
			}else{
				try{
					Set<Entry<String,List<String>>> entrySet = includeFile.entrySet();
					for (Entry<String, List<String>> entry : entrySet) {
						List<String> value = entry.getValue();
						for (String string : value) {
							if(string.indexOf(".css")>0){
								out.write("<link rel=\"stylesheet\" href='"+string+"' />");
								out.newLine();
							};
							if(string.indexOf(".js")>0){
								out.write("<script src='"+string+"'></script>");
								out.newLine();
							};
						}
					}
					return EVAL_PAGE;	
				}catch(Exception e){
					e.printStackTrace();
				}	
			}
		}
		return super.doStartTag();
	}

	@Override
	public void release() {
		super.release();
	}

	public String getInclude() {
		return include;
	}

	public void setInclude(String include) {
		this.include = include;
	}
	
}
