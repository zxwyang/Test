package com.lemon.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlDemo {

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		// TODO Auto-generated method stub
		
		//1.创建解析器
		SAXReader saxReader = new SAXReader();
		//获取文档对象
		File file = new File("src/test/resources/homework.xml"); 
		InputStream inputStream = new FileInputStream(file);
		Document document = saxReader.read(inputStream);
		
		//获取根节点和根节点名
		Element root = document.getRootElement();
		System.out.println("根节点："+root.getName());
		
		//获取根节点的属性值
		String keywork = root.attributeValue("keyword");
		System.out.println("根节点属性值："+keywork);
		
		//通过根节点一级一级遍历，拿到子节点
		List<Element> allelement = root.elements();
		for (int i = 0; i < allelement.size(); i++) {
			Element element = allelement.get(i);
			//获取根节点的标签和文本值
			String name = element.getName();
			System.out.println("标签名："+name);
			String text = element.getText();
			System.out.println("文本值："+text);
			
			List<Element> childelement = element.elements();
			for (int j = 0; j < childelement.size(); j++) {
				Element childele = childelement.get(j);
				String childname = childele.getName();
				String childtext = childele.getText();
				System.out.println("子元素标签名："+childname);
				System.out.println("子元素文本值："+childtext);
				
				String childkeywork = childele.attributeValue("keyword");
				System.out.println("子节点属性值："+childkeywork);
			}
		}
		
		
	}

}
