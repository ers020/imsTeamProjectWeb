package com.revature.log4j;

import org.apache.log4j.*;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Logger log = Logger.getRootLogger();
	
    public static void main( String[] args )
    {
    	log.trace("Doing a null check");
    	log.debug("Connected to database");
        log.info("Hello World!");
        log.warn("Someone is attempting to access unathorized resource");
        log.error("Exception thrown... doing stuff to recover.");
        log.fatal("Really bad stuff... shutting down application gracefully");
       
    }
}
