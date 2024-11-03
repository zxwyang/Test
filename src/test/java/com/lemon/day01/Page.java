package com.lemon.day01;

import java.util.List;

/**封装每一个<page>元素
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
