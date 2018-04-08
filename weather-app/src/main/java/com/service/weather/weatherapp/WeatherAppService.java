package com.service.weather.weatherapp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class WeatherAppService {
	
	@Inject
	private RestTemplate restTemplate;


	@HystrixCommand(fallbackMethod="defaultWeather")
	public String getWeather()
	{
		return restTemplate.getForEntity("http://weather-service/weather", String.class).getBody();
	}
	
	public String defaultWeather()
	{
		return "Weather Service not reachable";
	}
}
