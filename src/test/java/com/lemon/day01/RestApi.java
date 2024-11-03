package com.lemon.day01;

public class RestApi {

	private String caseId;
	private String name;
	private String url;
	private String type;
	private String desc;
	private String mobilephone;
	private String pwd;
	
	
	@Override
	public String toString() {
		return "RestApi [caseId=" + caseId + ", name=" + name + ", url=" + url + ", type=" + type + ", desc=" + desc
				+ ", mobilephone=" + mobilephone + ", pwd=" + pwd + "]";
	}
	public RestApi() {
		super();
	}
	public RestApi(String caseId, String name, String url, String type, String desc, String mobilephone, String pwd) {
		super();
		this.caseId = caseId;
		this.name = name;
		this.url = url;
		this.type = type;
		this.desc = desc;
		this.mobilephone = mobilephone;
		this.pwd = pwd;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
