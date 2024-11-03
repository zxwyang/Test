package com.lemon.day01;

import com.alibaba.fastjson.JSONObject;

/*
 * 序列化，（将Java格式转化为json格式字符串）
 * */
public class JsonDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Result result = new Result("1","注册成功");
		//JSONObject.toJSONString（）方法：将Java格式转化为json格式字符串
		String jsonstring = JSONObject.toJSONString(result,true);   //true是用来美化json格式（true也可以不填写）
		System.out.println(jsonstring);

	}

}
