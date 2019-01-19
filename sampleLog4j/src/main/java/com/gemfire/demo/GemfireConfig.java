package com.gemfire.demo;

import java.util.Properties;

import org.apache.geode.cache.DataPolicy;
import org.apache.geode.cache.GemFireCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.ReplicatedRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.CacheServerApplication;
import org.springframework.data.gemfire.config.annotation.EnableLocator;
import org.springframework.data.gemfire.config.annotation.EnableManager;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@Configuration
@ComponentScan
@EnableGemfireRepositories
@CacheServerApplication(name="personSample",logLevel="info")
@EnableLocator(host="localhost",port=10334)
@EnableManager(start=true)

//@ClientCacheApplication(locators= {@Locator(host="localhost",port=10987)})
public class GemfireConfig {
	
	@Bean
	Properties getGemfireProperties() {
		Properties properties= new Properties();
		properties.setProperty("name", "sampleGemfire");
		properties.setProperty("mcast-port", "0");
		properties.setProperty("log-level", "config");
//		properties.setProperty("locators", "localhost[10334]");
		return properties;
		
	}

/*
	@Bean
	@Autowired
	CacheFactoryBean getCache() {
		CacheFactoryBean bean = new CacheFactoryBean();
		bean.setClose(true);
		bean.setProperties(getGemfireProperties());
		return bean;
	}*/
	@Bean
	@Autowired
	ReplicatedRegionFactoryBean<Integer, Person> getPersonRegion(final GemFireCache cache){
		ReplicatedRegionFactoryBean<Integer,Person> bean = new ReplicatedRegionFactoryBean<>();
		bean.setCache(cache);
		bean.setName("person");
		bean.setPersistent(true);
		bean.setDataPolicy(DataPolicy.PERSISTENT_REPLICATE);
		return bean;
	}
/*	@Bean
	@Autowired
	LocalRegionFactoryBean<Integer, Person> getPersonRegion(final GemFireCache cache){
		LocalRegionFactoryBean<Integer,Person> bean = new LocalRegionFactoryBean<>();
		bean.setCache(cache);
		bean.setName("person");
		bean.setPersistent(true);
		bean.setDataPolicy(DataPolicy.PERSISTENT_REPLICATE);
		return bean;
	}*/

	
}
