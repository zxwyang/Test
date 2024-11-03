package com.lemon.day01;

import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;
/*
 * �����л�����json�ַ���ת��ΪJava����
 * 
 * */
public class JsonDemo {
	
	public static void main(String [] args) {
		//���ַ�����ʽ���valueֵ
		String jsonstring = "{\"status\":\"1\",\"message\":\"ע��ɹ�\"}";
		//JSONObject.parseObject������������ȡResult.class������еĹ��췽��������json�ַ���ת��ΪJava����
		Result result = JSONObject.parseObject(jsonstring, Result.class);     
		String status = result.getStatus();
		String message = result.getMessage();
		System.out.println(status);
		System.out.println(message);
		
		//��json�ַ������ݷ�װ��map��
		Map<String , String > map = (Map<String, String>) JSONObject.parse(jsonstring);        //ǿ������ת��
		System.out.println(map.get("status"));
		System.out.println(map.get("message"));
		
		//�༭�����е�key
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key);
		}
	}

}
