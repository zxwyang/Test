package com.lemon.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class XmlUtil {

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		// TODO Auto-generated method stub
		
		XmlUtil xmlUtil = new XmlUtil();
		xmlUtil.loadpages();
		
		//获取page集合并遍历
		List<Page> pages = xmlUtil.loadpages();
		for (Page page : pages) {
			System.out.println("页面关键字："+page.getPagekeyword());
			//获取UIElement集合并遍历
			List<UIElement> uiElements = page.getUiElement();
			for (UIElement uiElement : uiElements) {
				System.out.println(uiElement);
			}
			System.out.println("======================");
			
		}

	}
	
	public List<Page> loadpages() throws FileNotFoundException, DocumentException{
		//将数据读取出来，封装成对象，添加到集合中，再返回
		
		//创建解析器，用于读取XML文件
		SAXReader saxReader = new SAXReader();
		
		//获取XML文档对象
		File file = new File("src/test/resources/UILibrary.xml");    //声明XML文件路径
		InputStream inputStream = new FileInputStream(file);    //申明一个输入对象，通过对象的多态性，进行实例化
		Document document = saxReader.read(inputStream);      //创建document对象，读取XML文件
		
		//获取根节点，和根节点属性
		Element root = document.getRootElement();
		String rootname = root.getName();              //获取根节点的标签名<pages>
		String rootattribute = root.attributeValue("keyword");           //获取根节点的属性值
		String roottext = root.getText();              //获取根节点的文本值
		
		//通过根节点遍历，一级一级向下获取子节点
		List<Element> pageElementList = root.elements();             //获取根节点下面所有的子节点（当根节点下面的子节点都相同时使用）
		//List<Element> pageElementlist = root.elements("page");       //获取根节点下面名为page的子节点（用于存在不同子节点的情况下）
		
		//准备一个集合用于添加<page>对象，因为方法需要返回一个集合
		List<Page> pageList = new ArrayList<Page>();
		
		//遍历取出pageElementList集合中的每一个<page>元素
		for (int i = 0; i < pageElementList.size(); i++) {
			Element pageElement = pageElementList.get(i);            
			String pagename = pageElement.getName();
			String pagekeyword = pageElement.attributeValue("keyword");
			
			//准备一个list保存此<page>元素底下的所有<uiElement>子元素
			List<UIElement> uiElements = new ArrayList<UIElement>();
			
			//取出<page>集合中的每一个<uiElement>子元素
			List<Element> uiElementsList = pageElement.elements();
			//遍历uiElementsList集合中的每一个<uiElement>子元素
			for (int j = 0; j < uiElementsList.size(); j++) {
				//依次取出每一个
				Element uiElement = uiElementsList.get(j);
				//取出keyword属性
				String uikeyword = uiElement.attributeValue("keyword");
				//取出by属性
				String uiby = uiElement.attributeValue("by");
				//取出value属性
				String uivalue = uiElement.attributeValue("value");
				
				//封装成UIElement对象
				UIElement ui = new UIElement(uikeyword,uiby,uivalue);
				//添加到集合
				uiElements.add(ui);
			}
			//封装Page对象
			Page page = new Page(pagekeyword,uiElements);
			pageList.add(page);		
		}	
		//返回page对象
		return pageList ;
	}

}
