package com.lemon.day02;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestngParameterDome {
	/**
	* testng������
	*    ͨ��testng.xml����<parameter>Ԫ�����������
	*/
	@Test
	@Parameters(value = { "brwserType" })
	public void test(String brwserType) {
		System.out.println(brwserType);
	}
}
