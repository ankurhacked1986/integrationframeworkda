package com.ericsson.da.integration_framework_da;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.json.JSONObject;

public class MyProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		Message in = exchange.getIn();
        String msg = in.getBody(String.class);
        try {
//        JSONObject obj = new JSONObject(msg);
//        in.setHeader("incident_id",obj.get("id") );
//        in.setHeader("title", obj.get("title"));
//        in.setHeader("assignee", obj.get("assignee"));
        	@SuppressWarnings("unchecked")
			Map<String, Object> row = exchange.getIn().getBody(Map.class);
        	System.out.println(row);
        	in.setHeader("incident_id",row.get("id"));
            in.setHeader("title", row.get("title"));
            in.setHeader("assignee", row.get("assignee"));
            in.setHeader("mobile_phone_number", row.get("mobile_phone_number"));
        	in.setHeader(Exchange.HTTP_QUERY, "token=d71b186bd9086a68565bcf30659f3f575c6d326adf33b&uid=919038022119&to="+ row.get("mobile_phone_number")+"&custom_uid="+row.get("id")+System.currentTimeMillis()+"&text="+ "Hello "+ row.get("assignee") + " An incident with the incident id " + row.get("id") + " .. and  with the title  ... "+ row.get("title") + " .. is assigned to you... To resolve please send Resolve,<Incident_ID>");
        	  in.setBody("");
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
       
        
	}

}
