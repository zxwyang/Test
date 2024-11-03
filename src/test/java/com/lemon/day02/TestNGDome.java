package com.lemon.day02;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**@Test:用来标记测试方法
 * @author Administrator
 *
 */
public class TestNGDome {
  /*@Test
  public void f() {
	  //通过断言来比较期望结果和实际结果
	  Calculator calculator = new Calculator();
	  //实际运算结果
	  int actual = calculator.add(1, 3);
	  //通过断言来比较期望结果和实际结果
	  assertEquals(actual, 4);		  
  }*/
  @Test(priority=3)
  public void b() {
	  System.out.println("TestNGDemo.b()");
  }
  @Test(priority=2)
  public void a() {
	  System.out.println("TestNGDemo.a()");
  }
  @Test(priority=1)
  public void c() {
	  System.out.println("TestNGDemo.c()");
  }
  
}
