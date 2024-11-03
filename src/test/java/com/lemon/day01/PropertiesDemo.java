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
		//获取properties文件路径
		File file = new File("src/test/resources/jdbc.properties");   
		//判断文件是否存在，存在就返回true
		System.out.println(file.exists());                             
		//因为InputStream是抽象类，无法创建对象，所以只能创建子类对象
		InputStream iStream = new FileInputStream(file);  
		//调用load方法将流对象中的数据加载到properties对象中
		properties.load(iStream);                                          
		
        String username = properties.getProperty("jdbc.username");
        System.out.println(username);
        
        String password = properties.getProperty("jdbc.password");
        System.out.println(password);
        
        String url = properties.getProperty("jdbc.url");
        System.out.println(url);
		
	}

}
