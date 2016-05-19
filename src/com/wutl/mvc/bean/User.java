/**
 * 
 */
package com.wutl.mvc.bean;

/**
 * <pre>
 * 名称: 用户类
 * 功能: 
 * 作者: wutl
 * 版本 1.0[原始架构]
 * </pre>
 */

public class User  extends BaseInfo{
	private Integer id;// 主键
	private String userName;// 用户名
	private String realName;// 真实姓名
	private String browser;// 用户使用浏览器类型
	private String userKey;// 用户验证唯一标示
	private String password;// 用户密码
	private String cardno;//
	private String isvalid;// 是否有效 0 无效/删除 1有效
	private String idcard;// 身份证号
	private String phone;//电话号码
	private String email;//电子邮件
	private String address;//地址
	private String img;//个人照片地址
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String userName, String realName, String browser, String userKey, String password,
			String cardno, String isvalid, String idcard) {
		super();
		this.id = id;
		this.userName = userName;
		this.realName = realName;
		this.browser = browser;
		this.userKey = userKey;
		this.password = password;
		this.cardno = cardno;
		this.isvalid = isvalid;
		this.idcard = idcard;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	

	public String getIsvalid() {
		return isvalid;
	}

	public void setIsvalid(String isvalid) {
		this.isvalid = isvalid;
	}

	public String getIdcard() {
		return idcard;
	}
	
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

}
