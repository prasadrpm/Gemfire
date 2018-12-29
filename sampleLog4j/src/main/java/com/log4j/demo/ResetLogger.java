package com.log4j.demo;

import javax.annotation.PostConstruct;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ResetLogger {
	
	private final static Logger logger = Logger.getLogger(ResetLogger.class);

	@SuppressWarnings("static-access")
	@RequestMapping(method=RequestMethod.POST,path="/defaultloggerlevel")
	public String getDefaultLoggerLever() {
		logger.error("default Logger lever is ---->"+logger.getRootLogger().getLevel().toString());
		return logger.getRootLogger().getLevel().toString();
		
	}
	@RequestMapping(method=RequestMethod.POST,path="/resetloggerlevel")
	public String resetLoggerLevel() {
		org.apache.log4j.LogManager.resetConfiguration();
		return "";
	}
	@SuppressWarnings("static-access")
	@RequestMapping(method=RequestMethod.POST,
			path="/changeoggerlevel")
	public String changeLoggerLevel(@RequestParam String level) {
		if(logger.equals(Level.ERROR))
//		logger.getRootLogger().setLevel(Level.ERROR);
		LogManager.getLogger(ResetLogger.class).setLevel(Level.ERROR);
		return logger.getRootLogger().getLevel().toString();
	}
	@PostConstruct
	public void init() {
		System.out.println("init called");
	}

}
