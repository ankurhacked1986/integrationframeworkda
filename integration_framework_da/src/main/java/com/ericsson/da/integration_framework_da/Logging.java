package com.ericsson.da.integration_framework_da;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.json.JSONObject;

public class Logging implements Processor {

	public void process(Exchange exchange) throws Exception {
//		Message in = exchange.getIn();
//        Map<String, Object> msg = in.getHeaders();
//        System.out.println(msg);
		
		Message in = (Message) exchange.getIn();
        String msg = in.getBody(String.class);
        msg = msg.replaceAll("[\\[\\]\\(\\)]", "");
       // JSONObject obj = new JSONObject(msg);
        System.out.println(msg);
		
	}

}
