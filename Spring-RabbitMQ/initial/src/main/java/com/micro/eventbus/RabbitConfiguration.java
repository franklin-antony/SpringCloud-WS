package com.micro.eventbus;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

	
    static final String topicExchangeName = "spring-boot-exchange";
    static final String queueName = "spring.boot.q";

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }
	
    
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }   
    
    @Bean
    public ConnectionFactory connectionFactory() {
    	
    	  CachingConnectionFactory connectionFactory=new CachingConnectionFactory("sidewinder.rmq.cloudamqp.com");
    	  connectionFactory.setUsername("jftwwnjh");
    	  connectionFactory.setPassword("arghG7d25-NGAPxaY35xgETjuAfGGonj");
    	  connectionFactory.setVirtualHost("jftwwnjh");

    	  //Recommended settings
    	  connectionFactory.setRequestedHeartBeat(30);
    	  connectionFactory.setConnectionTimeout(30000);
    	
          return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

 
    

}