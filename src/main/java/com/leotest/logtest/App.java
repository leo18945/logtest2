package com.leotest.logtest;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leotest.logtest.test2.MyTest;

public class App {
    public static void main( String[] args ){
        Logger log1 = LoggerFactory.getLogger(App.class);
        Logger log2 = LoggerFactory.getLogger("com.leotest");
        Logger log3 = LoggerFactory.getLogger("com.leotest.logtest");
        Logger log4 = LoggerFactory.getLogger(MyTest.class);
        log1.info("log info");
        
        org.apache.logging.log4j.Logger loggerWithJsonLayout = LogManager.getLogger("LOGGER_WITH_JSON_LAYOUT");
        loggerWithJsonLayout.info("json message");
    }
}