package com.gemfire.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableLocator;

import com.log4j.demo.SampleLog4jApplication;

@SpringBootApplication
@CacheServerApplication(logLevel="info")
@EnableLocator(host="localhost",port=10334)
public class GemfireServer {

	public static void main(String[] args) {
		SpringApplication.run(SampleLog4jApplication.class, args);

	}
	
}
