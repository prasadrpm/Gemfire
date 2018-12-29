package com.gemfire.demo;

import java.util.Properties;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.DataPolicy;
import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.ReplicatedRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication.Locator;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@Configuration
@ComponentScan
@EnableGemfireRepositories
//@ClientCacheApplication(locators= {@Locator(host="localhost",port=10987)})
public class GemfireConfig {
	
	@Bean
	Properties getGemfireProperties() {
		Properties properties= new Properties();
		properties.setProperty("name", "sampleGemfire");
		properties.setProperty("mcast-port", "0");
		return properties;
		
	}

	@Bean
	@Autowired
	CacheFactoryBean getCache() {
		CacheFactoryBean bean = new CacheFactoryBean();
		bean.setClose(true);
		bean.setProperties(getGemfireProperties());
		return bean;
	}
	/*@Bean
	@Autowired
	ReplicatedRegionFactoryBean<Integer, Person> getPersonRegion(final GemFireCache cache){
		ReplicatedRegionFactoryBean<Integer,Person> bean = new ReplicatedRegionFactoryBean<>();
		bean.setCache(cache);
		bean.setName("person");
		bean.setPersistent(true);
		bean.setDataPolicy(DataPolicy.PRELOADED);
		return bean;
	}*/
	@Bean
	@Autowired
	LocalRegionFactoryBean<Integer, Person> getPersonRegion(final GemFireCache cache){
		LocalRegionFactoryBean<Integer,Person> bean = new LocalRegionFactoryBean<>();
		bean.setCache(cache);
		bean.setName("person");
		bean.setPersistent(true);
		bean.setDataPolicy(DataPolicy.PRELOADED);
		return bean;
	}
}
