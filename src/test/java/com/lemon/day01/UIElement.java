package com.lemon.day01;

/**��װÿһ��Page��<uiElement>Ԫ�ص����ݣ����ԣ�
 * @author Administrator
 *
 */
public class UIElement {

	private String keyword;
	private String by;
	private String value;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	//�ղι��췽��
	public UIElement() {
		
	}
	//���ι��췽��
	public UIElement(String keyword,String by,String value) {
		this.keyword = keyword;
		this.by = by;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "keyword="+keyword+",by="+by+",value="+value;
	}
}
