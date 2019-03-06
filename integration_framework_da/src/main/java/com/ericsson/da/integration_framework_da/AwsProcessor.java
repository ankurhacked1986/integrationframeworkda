package com.ericsson.da.integration_framework_da;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.json.JSONObject;

public class AwsProcessor implements Processor{

	public void process(Exchange exchange) throws Exception {
		try {
		Message in = exchange.getIn();
        String msg = in.getBody(String.class);
        msg = msg.replaceAll("[\\[\\]\\(\\)]", "");
        JSONObject row = new JSONObject(msg);
        System.out.println("Processing row...." + row + "...now");
     //   Map<String, Object> row = exchange.getIn().getBody(Map.class);
        String message_body = (String) row.get("message_body_text");
        String[] body = message_body.split(",");
        String action = body[0];
        String incident_id = body[1];
        in.setHeader("id", row.get("id"));
        in.setHeader("incident_id",incident_id);
        in.setHeader("action", action);
        in.setHeader("mobile_phone_number", row.get("contact_uid"));  
        System.out.println(row.get("id"));
		}
		catch(Exception e)
		{
			System.out.println("Nothing to process here");
		}
		
	}

}
