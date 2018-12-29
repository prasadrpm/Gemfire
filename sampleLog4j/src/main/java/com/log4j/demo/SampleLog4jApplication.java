package com.log4j.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages="com.gemfire.demo")
public class SampleLog4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleLog4jApplication.class, args);
	}

}
