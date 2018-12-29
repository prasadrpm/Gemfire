package com.gemfire.demo;

import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.springframework.context.annotation.Bean;

//@Configuration
public class SimpleCacheListener {

	@Bean
	public static Cache getCache() {
		
		Cache cache = new CacheFactory()
			      .set("cache-xml-file", "cache.xml")
			      .create();
		return cache;
	}
	@Bean
	public static Region<?, ?> getRegion(){
		Region<String,String> exampleRegion = getCache().getRegion("exampleRegion");
		return exampleRegion;
	}
}
