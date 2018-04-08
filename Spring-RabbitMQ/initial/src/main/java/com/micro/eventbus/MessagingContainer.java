package com.micro.eventbus;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MessagingContainer {

	
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) 
    {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(RabbitConfiguration.queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }
    
    @Bean
    MessageListenerAdapter listenerAdapter(MessageConsumer receiver)
    {
        return new MessageListenerAdapter(receiver, "onReceiveMessage");
    }
	
}
