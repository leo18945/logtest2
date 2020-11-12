package com.leotest.logtest;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.Level;


public class App2 {
	public static void main( String[] args ){
		//test0();
		//test1();
		//test2();
		test3();
    }
	
	public static void test0() {
    	Logger log = LogManager.getLogger("mylogger");
    	log.info("json message");
    	
    	Logger log2 = LogManager.getLogger(App2.class);
    	log2.info("json message");
    }
	
    public static void test1() {
    	Configurator.initialize(new DefaultConfiguration());
    	Configurator.setRootLevel(Level.INFO);
    	
    	Logger log = LogManager.getLogger("cabc793skeh785whbj");
    	log.info("json message");
    }
    
    public static void test2() {
    	LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
    	LoggerContext ctx2 = (LoggerContext) LogManager.getContext(true);
    	
    	Configuration config = ctx.getConfiguration();
    	
    	LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME); 
    	loggerConfig.setLevel(Level.DEBUG);
    	
    	// This causes all Loggers to refetch information from their LoggerConfig.
    	ctx.updateLoggers();
    }
    
    public static void test3() {
    	LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
    	
    	Configuration config = ctx.getConfiguration();
    	
    	LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME); 
    	loggerConfig.setLevel(Level.DEBUG);
    	
    	LoggerConfig app2Log = config.getLoggerConfig("com.leotest.logtest.App2");
    	app2Log.setLevel(Level.INFO);
    	
    	// This causes all Loggers to refetch information from their LoggerConfig.
    	ctx.updateLoggers();
    	
    	Logger log = LogManager.getLogger(App2.class);
    	log.info("json message");
    }
}