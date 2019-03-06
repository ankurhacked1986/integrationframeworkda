package com.ericsson.da.integration_framework_da;

import org.apache.camel.spring.Main;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	Main main = new Main();
    	main.setApplicationContextUri("applicationContext.xml");
    	main.enableHangupSupport();
    	System.out.println("\n\nApplication has now been started. You can press ctrl + c to stop.\n\n");
    	main.run();
    	  
    }
}
