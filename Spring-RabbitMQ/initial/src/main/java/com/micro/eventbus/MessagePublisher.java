package com.micro.eventbus;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class MessagePublisher {

	    	
	   private static final Logger log = LoggerFactory.getLogger(MessagePublisher.class);
	   private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	   	
	   @Inject
       private RabbitTemplate rabbitTemplate;
	   
	    @Scheduled(fixedRate = 5000)
	    public void reportCurrentTime() {
	    	log.info("Sending a message to cloudamqp. The time is now {}", dateFormat.format(new Date()));
	    	rabbitTemplate.convertAndSend(RabbitConfiguration.topicExchangeName, "foo.bar.baz", "Message send at : "+dateFormat.format(new Date()));
	        
	    }
}
