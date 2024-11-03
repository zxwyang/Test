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
		
		//��ȡpage���ϲ�����
		List<Page> pages = xmlUtil.loadpages();
		for (Page page : pages) {
			System.out.println("ҳ��ؼ��֣�"+page.getPagekeyword());
			//��ȡUIElement���ϲ�����
			List<UIElement> uiElements = page.getUiElement();
			for (UIElement uiElement : uiElements) {
				System.out.println(uiElement);
			}
			System.out.println("======================");
			
		}

	}
	
	public List<Page> loadpages() throws FileNotFoundException, DocumentException{
		//�����ݶ�ȡ��������װ�ɶ�����ӵ������У��ٷ���
		
		//���������������ڶ�ȡXML�ļ�
		SAXReader saxReader = new SAXReader();
		
		//��ȡXML�ĵ�����
		File file = new File("src/test/resources/UILibrary.xml");    //����XML�ļ�·��
		InputStream inputStream = new FileInputStream(file);    //����һ���������ͨ������Ķ�̬�ԣ�����ʵ����
		Document document = saxReader.read(inputStream);      //����document���󣬶�ȡXML�ļ�
		
		//��ȡ���ڵ㣬�͸��ڵ�����
		Element root = document.getRootElement();
		String rootname = root.getName();              //��ȡ���ڵ�ı�ǩ��<pages>
		String rootattribute = root.attributeValue("keyword");           //��ȡ���ڵ������ֵ
		String roottext = root.getText();              //��ȡ���ڵ���ı�ֵ
		
		//ͨ�����ڵ������һ��һ�����»�ȡ�ӽڵ�
		List<Element> pageElementList = root.elements();             //��ȡ���ڵ��������е��ӽڵ㣨�����ڵ�������ӽڵ㶼��ͬʱʹ�ã�
		//List<Element> pageElementlist = root.elements("page");       //��ȡ���ڵ�������Ϊpage���ӽڵ㣨���ڴ��ڲ�ͬ�ӽڵ������£�
		
		//׼��һ�������������<page>������Ϊ������Ҫ����һ������
		List<Page> pageList = new ArrayList<Page>();
		
		//����ȡ��pageElementList�����е�ÿһ��<page>Ԫ��
		for (int i = 0; i < pageElementList.size(); i++) {
			Element pageElement = pageElementList.get(i);            
			String pagename = pageElement.getName();
			String pagekeyword = pageElement.attributeValue("keyword");
			
			//׼��һ��list�����<page>Ԫ�ص��µ�����<uiElement>��Ԫ��
			List<UIElement> uiElements = new ArrayList<UIElement>();
			
			//ȡ��<page>�����е�ÿһ��<uiElement>��Ԫ��
			List<Element> uiElementsList = pageElement.elements();
			//����uiElementsList�����е�ÿһ��<uiElement>��Ԫ��
			for (int j = 0; j < uiElementsList.size(); j++) {
				//����ȡ��ÿһ��
				Element uiElement = uiElementsList.get(j);
				//ȡ��keyword����
				String uikeyword = uiElement.attributeValue("keyword");
				//ȡ��by����
				String uiby = uiElement.attributeValue("by");
				//ȡ��value����
				String uivalue = uiElement.attributeValue("value");
				
				//��װ��UIElement����
				UIElement ui = new UIElement(uikeyword,uiby,uivalue);
				//��ӵ�����
				uiElements.add(ui);
			}
			//��װPage����
			Page page = new Page(pagekeyword,uiElements);
			pageList.add(page);		
		}	
		//����page����
		return pageList ;
	}

}
