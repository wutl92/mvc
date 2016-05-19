/**
 * 
 */
package com.wutl.mvc.tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * 名称: 
 * 功能:输出信息
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public class OutMsgUtil {
	/**
	 * 对外相应信息
	 * @param message
	 * @param response
	 */
	public static void outMessage(String message , HttpServletResponse response){
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
