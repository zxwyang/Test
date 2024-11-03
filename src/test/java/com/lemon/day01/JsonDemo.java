package com.lemon.day01;

import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
/*
 * 反序列化，将json字符串转化为Java对象
 * 
 * */
public class JsonDemo {
	
	public static void main(String [] args) {
		//以字符串形式输出value值
		String jsonstring = "{\"status\":\"1\",\"message\":\"注册成功\"}";
		//JSONObject.parseObject（）方法：获取Result.class这个类中的构造方法，并将json字符串转化为Java对象
		Result result = JSONObject.parseObject(jsonstring, Result.class);     
		String status = result.getStatus();
		String message = result.getMessage();
		System.out.println(status);
		System.out.println(message);
		
		//将json字符串内容封装到map中
		Map<String , String > map = (Map<String, String>) JSONObject.parse(jsonstring);        //强制向下转型
		System.out.println(map.get("status"));
		System.out.println(map.get("message"));
		
		//编辑集合中的key
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key);
		}
	}

}
