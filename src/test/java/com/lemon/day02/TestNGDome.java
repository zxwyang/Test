package com.lemon.day02;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**@Test:������ǲ��Է���
 * @author Administrator
 *
 */
public class TestNGDome {
  /*@Test
  public void f() {
	  //ͨ���������Ƚ����������ʵ�ʽ��
	  Calculator calculator = new Calculator();
	  //ʵ��������
	  int actual = calculator.add(1, 3);
	  //ͨ���������Ƚ����������ʵ�ʽ��
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
