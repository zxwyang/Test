package com.lemon.day02;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationDemo {
	
	@Test
	public void test1() {
		System.out.println("AnnotationDemo.test1()");
	}
	
	@Test
	public void test2() {
		System.out.println("AnnotationDemo.test2()");
	}
	
	/**
	 * �������׼�ִ��ǰִ�У�����ִֻ��һ��
	 */
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("AnnotationDemo.beforeSuite()");
	}
	
	/**
	 * ���������Լ�ִ��ǰִ��
	 */
	@BeforeTest
	public void beforeTest() {
		System.out.println("AnnotationDemo.beforeTest()");
	}
	
	/**
	 * �ڵ�ǰ������ִ��ǰִ��
	 */
	@BeforeClass
	public void beforeClass() {
		System.out.println("AnnotationDemo.beforeClass()");
	}
	
	/**
	 * ��ÿ�����Է���ִ��ǰ��ִ��
	 */
	@BeforeMethod
	public void beforeMethor() {
		System.out.println("AnnotationDemo.beforeMethor()");
	}
	/**
	 * �������׼�ִ�к�ִ�У�����ִֻ��һ��
	 */
	@AfterSuite
	public void afterSuite() {
		System.out.println("AnnotationDemo.afterSuite()");
	}	
	/**
	 * ���������Լ�ִ�к�ִ��
	 */
	@AfterTest
	public void afterTest() {
		System.out.println("AnnotationDemo.afterTest()");
	}	
	/**
	 * �ڵ�ǰ������ִ�к�ִ��
	 */
	@AfterClass
	public void afterClass() {
		System.out.println("AnnotationDemo.afterClass()");
	}	
	/**
	 * ��ÿ�����Է���ִ�к���ִ��
	 */
	@AfterMethod
	public void afterMethod() {
		System.out.println("AnnotationDemo.afterMethod()");
	}
}
