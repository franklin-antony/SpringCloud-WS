package com.service.weather.weatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.servo.jsr166e.ThreadLocalRandom;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class WeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}
	
	
	
	private String[] weather = new String[] {"Sunny","Cloudy","Windy"};
	
	@GetMapping("/weather")
	public String getWeather()
	{
		ThreadLocalRandom.current().nextInt(0,2);
		
		
		return weather[ThreadLocalRandom.current().nextInt(0,2)];
		
	}
}
