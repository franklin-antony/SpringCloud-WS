package com.me.micro.app.microapp;

import javax.inject.Inject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class MicroAppApplication {

	
	
	@Inject
	private RestTemplate restTemplate;
	
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroAppApplication.class, args);
	}
	
	@GetMapping("/balancedMessage")
	public String balancedMessage()
	{
		
		return "Retrieving information from nodes: "+ restTemplate.getForEntity("http://service", String.class).getBody();
	}
}
