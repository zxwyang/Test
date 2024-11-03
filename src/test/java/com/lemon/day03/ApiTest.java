package com.lemon.day03;

import java.io.IOException;
import java.util.Arrays;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import java.util.Map;

import org.apache.http.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;


public class ApiTest {
	@Test
	public void testGet() throws ClientProtocolException, IOException {
		// 参数（账号已注册）
		String params = "username=nickjiang&password=123456";
		// 接口地址
		String url = "http://localhost:8080/user/register";
		// 创建对象
		HttpGet httpGet = new HttpGet(url + "?" + params);
		// 准备HttpClient客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 发送请求
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		// 取出响应状态码
		int code = httpResponse.getStatusLine().getStatusCode();
		System.out.println("状态码：" + code);
		// 取出响应头 数组需要使用Arrays.toString()转为字符串
		Header[] headers = httpResponse.getAllHeaders();
		System.out.println("响应头：" + Arrays.toString(headers));
		// 取出响应报文
		String result = EntityUtils.toString(httpResponse.getEntity());
		System.out.println("响应报文：" + result);
		// 判断实际值跟期望值
		@SuppressWarnings("unchecked")
		Map<String, String> resultMap = (Map<String, String>) JSONObject.parse(result);
		String actual = resultMap.get("message");
		String expected = "账号已注册";
		//进行断言
		Assert.assertEquals(actual, expected);
	}

	@Test
	public void testPostByForm() throws ClientProtocolException, IOException {
		// 参数（账号已注册）
		String params = "username=nickjiang&password=123456";
		// 接口地址
		String url = "http://localhost:8080/user/login";
		// 创建对象
		HttpPost httpPost = new HttpPost(url);
		// 添加请求头（指定以表单方式来提交参数）
		httpPost.addHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"));
		// 将参数传入请求体
		httpPost.setEntity(new StringEntity(params, "UTF-8"));
		// 准备HttpClient客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 发送请求
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		// 取出响应状态码
		int code = httpResponse.getStatusLine().getStatusCode();
		System.out.println("状态码：" + code);
		// 取出响应头 数组需要使用Arrays.toString()转为字符串
		Header[] headers = httpResponse.getAllHeaders();
		System.out.println("响应头：" + Arrays.toString(headers));
		// 取出响应报文
		String result = EntityUtils.toString(httpResponse.getEntity());
		System.out.println("响应报文：" + result);
		// 判断实际值跟期望值
		// 判断实际值跟期望值
		@SuppressWarnings("unchecked")
		Map<String, String> resultMap = (Map<String, String>) JSONObject.parse(result);
		String actual = resultMap.get("message");
		String expected = "用户登录成功";
		// 进行断言
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testPostByJson() throws ParseException, IOException{
		//测试数据(查无此人)
		String expected = "查无此人";
		String params = "{\"username\":\"nickjiang\",\"password\":\"123456\"}";
		//接口地址
		String url = "http://localhost:8080/user/resetpassword";
		//创建HttpPost对象
		HttpPost httpPost = new HttpPost(url);
		//添加请求头（指定以表单方式来提交参数）
		httpPost.addHeader(new BasicHeader("Content-Type","application/json;charset=UTF-8"));
		//添加参数到请求体
		httpPost.setEntity(new StringEntity(params,"UTF-8"));
		//准备客户端
		CloseableHttpClient httpClient = HttpClients.createDefault();
		//发送请求
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		//取出响应状态码
		int code = httpResponse.getStatusLine().getStatusCode();
		System.out.println("状态码为："+code);
		//取出响应头
		Header [] headers = httpResponse.getAllHeaders();
		System.out.println("响应头："+Arrays.toString(headers));
		//取出响应报文
		String result = EntityUtils.toString(httpResponse.getEntity());
		System.out.println("响应报文："+result);
		//判断实际值跟期望值
		Map<String,String> resultMap = (Map<String, String>) JSONObject.parse(result);
		String actual = resultMap.get("message");
		//进行断言
		Assert.assertEquals(actual,expected);		
		}
		
}
