/**
 * 
 */
package com.wutl.mvc.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.chainsaw.Main;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.util.SystemOutLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wutl.mvc.bean.User;
import com.wutl.mvc.common.sysenum.LoginStates;
import com.wutl.mvc.common.system.UserManager;
import com.wutl.mvc.service.system.MenuService;
import com.wutl.mvc.service.system.UserSerivce;
import com.wutl.mvc.tool.OutMsgUtil;
import com.wutl.mvc.tool.Tools;
import org.w3c.dom.Document;

import java.io.*;
import java.util.List;

/**
 * <pre>
 * 名称: 登陆控制器
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */
@Controller
@RequestMapping("/login")
@SuppressWarnings("all")
public class LoginController {
	@Autowired
	private UserSerivce userService;
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(params="check")
	public void checkUser(User user,HttpServletResponse response,HttpSession session){
		LoginStates check = userService.checkUser(user,session);
		String message = "";
		if(LoginStates.noUser.equals(check)){
			message = "用户名或密码错误！";
		}else if(LoginStates.sucess.equals(check)) {
			message = "true";
			UserManager.addPersonData(session, "menuTree", menuService.getPersonMenu());
		}else if(LoginStates.inUser.equals(check)){
			message = "用户已经在线，请勿重新登录！";
		}
		OutMsgUtil.outMessage(message, response);
	}
	@RequestMapping(params="go")
	public ModelAndView goLogin(){
		return new ModelAndView("system/login");
	}

	@RequestMapping(params="goback")
	public ModelAndView goback(HttpSession session){
		UserManager.getOnlineUsers().remove(session.getId());//去除在线用户
		session.invalidate();//消除当前Session
		return new ModelAndView("redirect:login.do?go");
	}
	@RequestMapping(params="d1")
	public void demo(HttpServletResponse response) throws IOException, TransformerException, ParserConfigurationException {
		/*File file  = new File("E://test//吴同立--转正申请表.doc");
		FileInputStream fin = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fin);
		String bodyText = null;
		WordExtractor ex = new WordExtractor(bis);
		response.setCharacterEncoding("gbk");
		bodyText = ex.getText();
		response.getWriter().write(bodyText);*/
		response.setCharacterEncoding("UTF-8");
		convert2Html("E://test//软件详细设计说明书.doc",response);
	}


	public static void convert2Html(String fileName,HttpServletResponse resp)
			throws TransformerException, IOException,
			ParserConfigurationException {
		HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(fileName));//WordToHtmlUtils.loadDoc(new FileInputStream(inputFile));
		WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
				DocumentBuilderFactory.newInstance().newDocumentBuilder()
						.newDocument());
		wordToHtmlConverter.setPicturesManager( new PicturesManager()
		{
			public String savePicture(byte[] content,
									  PictureType pictureType, String suggestedName,
									  float widthInches, float heightInches )
			{
				return suggestedName;
			}
		} );
		wordToHtmlConverter.processDocument(wordDocument);
		//save pictures
		List pics=wordDocument.getPicturesTable().getAllPictures();
		if(pics!=null){
			for(int i=0;i<pics.size();i++){
				Picture pic = (Picture)pics.get(i);
				System.out.println();
				try {
					pic.writeImageContent(new FileOutputStream("E:/test/"
							+ pic.suggestFullFileName()));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		Document htmlDocument = wordToHtmlConverter.getDocument();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DOMSource domSource = new DOMSource(htmlDocument);
		StreamResult streamResult = new StreamResult(out);

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer serializer = tf.newTransformer();
		serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		serializer.setOutputProperty(OutputKeys.METHOD, "html");
		serializer.transform(domSource, streamResult);
		out.close();
		System.out.println(new String(out.toByteArray()));
		resp.getWriter().write(new String(out.toByteArray(),"utf-8"));
}
}
