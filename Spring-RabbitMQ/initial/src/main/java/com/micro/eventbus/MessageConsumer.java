package com.micro.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

	private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);
	   
    public void onReceiveMessage(String message) {
    	log.info("Received  <" + message + ">");


    }


}
