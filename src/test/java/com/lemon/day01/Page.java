package com.lemon.day01;

import java.util.List;

/**��װÿһ��<page>Ԫ��
 * @author Administrator
 *
 */
public class Page {

	private String pagekeyword;
	private List<UIElement> uiElement;
	
	public String getPagekeyword() {
		return pagekeyword;
	}
	public void setPagekeyword(String pagekeyword) {
		this.pagekeyword = pagekeyword;
	}
	
	public List<UIElement> getUiElement (){
		return uiElement;
	}
	public void setUiElenmt(List<UIElement> uiElement) {
		this.uiElement = uiElement;
	}
	
	public Page() {
		
	}
	
	public Page(String pagekeyword, List<UIElement> uiElement) {
		this.pagekeyword = pagekeyword;
		this.uiElement = uiElement;
	}
}
