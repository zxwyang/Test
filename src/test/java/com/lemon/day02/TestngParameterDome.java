package com.lemon.day02;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngParameterDome {
	/**
	* testng参数化
	*    通过testng.xml定义<parameter>元素来定义变量
	*/
	@Test
	@Parameters(value = { "brwserType" })
	public void test(String brwserType) {
		System.out.println(brwserType);
	}
}
