package com.ericsson.da.integration_framework_da;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class CallingWhatsApp implements Processor {

	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
        in.setHeader(Exchange.HTTP_QUERY, "token=0739d1e07cad83cc035ae30df946f1745c5153743b353&uid=919038022119&to=919038022119&custom_uid=msg-9188&text=Hello+World");
		
	}

}
