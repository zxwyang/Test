package com.lemon.day02;

import org.testng.annotations.Test;

public class DependDemo {
	
	@Test
	public void test1() {
		System.out.println("DependDemo.test1()");
	}

	@Test(enabled=false)
	public void test2() {
		System.out.println("DependDemo.test2()");
	}
}
