package com.sivalabs.quickstart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HelloService 
{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
    public String sayHello(String name)
    {
        logger.debug("Name : {}", name);
    	return "Hello "+name;
    }
}
