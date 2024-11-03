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
		
		//1.����������
		SAXReader saxReader = new SAXReader();
		//��ȡ�ĵ�����
		File file = new File("src/test/resources/homework.xml"); 
		InputStream inputStream = new FileInputStream(file);
		Document document = saxReader.read(inputStream);
		
		//��ȡ���ڵ�͸��ڵ���
		Element root = document.getRootElement();
		System.out.println("���ڵ㣺"+root.getName());
		
		//��ȡ���ڵ������ֵ
		String keywork = root.attributeValue("keyword");
		System.out.println("���ڵ�����ֵ��"+keywork);
		
		//ͨ�����ڵ�һ��һ���������õ��ӽڵ�
		List<Element> allelement = root.elements();
		for (int i = 0; i < allelement.size(); i++) {
			Element element = allelement.get(i);
			//��ȡ���ڵ�ı�ǩ���ı�ֵ
			String name = element.getName();
			System.out.println("��ǩ����"+name);
			String text = element.getText();
			System.out.println("�ı�ֵ��"+text);
			
			List<Element> childelement = element.elements();
			for (int j = 0; j < childelement.size(); j++) {
				Element childele = childelement.get(j);
				String childname = childele.getName();
				String childtext = childele.getText();
				System.out.println("��Ԫ�ر�ǩ����"+childname);
				System.out.println("��Ԫ���ı�ֵ��"+childtext);
				
				String childkeywork = childele.attributeValue("keyword");
				System.out.println("�ӽڵ�����ֵ��"+childkeywork);
			}
		}
		
		
	}

}
