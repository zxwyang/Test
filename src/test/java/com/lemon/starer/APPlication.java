package com.lemon.starer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.lemon.api"})       //扫描组件，扫描哪些类中定义了接口，并把它维护在map里面             指定需要扫描的包：basePackages={"com.lemon.api"}
@SpringBootApplication           //springboot入口程序，内置了Tomcat
public class APPlication {
	public static void main(String [] args) {
		SpringApplication.run(APPlication.class, args);
	}
}
