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
	 * 在整个套件执行前执行，而且只执行一次
	 */
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("AnnotationDemo.beforeSuite()");
	}
	
	/**
	 * 在整个测试集执行前执行
	 */
	@BeforeTest
	public void beforeTest() {
		System.out.println("AnnotationDemo.beforeTest()");
	}
	
	/**
	 * 在当前测试类执行前执行
	 */
	@BeforeClass
	public void beforeClass() {
		System.out.println("AnnotationDemo.beforeClass()");
	}
	
	/**
	 * 在每个测试方法执行前先执行
	 */
	@BeforeMethod
	public void beforeMethor() {
		System.out.println("AnnotationDemo.beforeMethor()");
	}
	/**
	 * 在整个套件执行后执行，而且只执行一次
	 */
	@AfterSuite
	public void afterSuite() {
		System.out.println("AnnotationDemo.afterSuite()");
	}	
	/**
	 * 在整个测试集执行后执行
	 */
	@AfterTest
	public void afterTest() {
		System.out.println("AnnotationDemo.afterTest()");
	}	
	/**
	 * 在当前测试类执行后执行
	 */
	@AfterClass
	public void afterClass() {
		System.out.println("AnnotationDemo.afterClass()");
	}	
	/**
	 * 在每个测试方法执行后先执行
	 */
	@AfterMethod
	public void afterMethod() {
		System.out.println("AnnotationDemo.afterMethod()");
	}
}
