package com.lemon.day01;

import com.alibaba.fastjson.JSONObject;

/*
 * ���л�������Java��ʽת��Ϊjson��ʽ�ַ�����
 * */
public class JsonDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Result result = new Result("1","ע��ɹ�");
		//JSONObject.toJSONString������������Java��ʽת��Ϊjson��ʽ�ַ���
		String jsonstring = JSONObject.toJSONString(result,true);   //true����������json��ʽ��trueҲ���Բ���д��
		System.out.println(jsonstring);

	}

}
