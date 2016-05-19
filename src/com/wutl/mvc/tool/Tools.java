/**
 * 
 */
package com.wutl.mvc.tool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wutl.mvc.bean.BaseInfo;

/**
 * <pre>
 * 名称: 工具类
 * 功能: 我的工具
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */
@SuppressWarnings("all")
public class Tools {
	
	private static final Logger log = LoggerFactory.getLogger(Tools.class);
	
	/**
	 * 分割字符串
	 * @param src
	 * @param op
	 * @return 如果其中有一个为Null或者""则返回一个长度为0的数组
	 */
	public static String[] splitStringByOp(String src, String op){
		if(isEmpty(src)||isEmpty(op)){
			return new String[0];			
		}else{
			return src.split(op);
		}
	}
	/**
	 * 判断是否为空，如果是String null和""都返回true
	 * @param src
	 * @return
	 */
	public static boolean isEmpty(Object src){
		if(src==null||"".equals(src)){
			log.info(src+"对象为null或者字符串空！");
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 页面静态文件引入集合
	 * @param filestring
	 * @return
	 */
	public static Map<String,List<String>> getIncludeFile(String filestring){
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		try {
			SAXReader read = new SAXReader();//创建saxread对象
			String path = Tools.class.getResource("/").toString();
			Document document = read.read(path+"tags/include.xml");//获得xml文档对象
			Element rootElement = document.getRootElement();
			//获节点元素的下集节点元素集合
			for (Iterator piterator = rootElement.elementIterator();piterator.hasNext();) {
				Element pelement = (Element) piterator.next();
				String key = null;
				if(pelement.attributeIterator().hasNext()){
					Attribute next = (Attribute)pelement.attributeIterator().next();
					key = (next.getStringValue());
				}
				List<String> value = new ArrayList<String>();
				for (Iterator siterator = pelement.elementIterator(); siterator.hasNext();) {
					Element selement = (Element) siterator.next();
					value.add(selement.getText());
				}
				if("all".equals(filestring)||filestring.indexOf(key)>-1){
					map.put(key, value);
				}
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 设置基础信息
	 * @param baseInfo
	 * @param request
	 * @return
	 */
	public static BaseInfo setBaseInfo(BaseInfo baseInfo,HttpServletRequest request){
		return null;
	} 
}
