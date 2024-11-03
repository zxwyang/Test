package com.lemon.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.rowset.JdbcRowSet;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties properties = new Properties();
		//��ȡproperties�ļ�·��
		File file = new File("src/test/resources/jdbc.properties");   
		//�ж��ļ��Ƿ���ڣ����ھͷ���true
		System.out.println(file.exists());                             
		//��ΪInputStream�ǳ����࣬�޷�������������ֻ�ܴ����������
		InputStream iStream = new FileInputStream(file);  
		//����load�������������е����ݼ��ص�properties������
		properties.load(iStream);                                          
		
        String username = properties.getProperty("jdbc.username");
        System.out.println(username);
        
        String password = properties.getProperty("jdbc.password");
        System.out.println(password);
        
        String url = properties.getProperty("jdbc.url");
        System.out.println(url);
		
	}

}
