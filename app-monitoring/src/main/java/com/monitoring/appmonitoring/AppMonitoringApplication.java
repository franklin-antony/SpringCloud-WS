package com.monitoring.appmonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class AppMonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMonitoringApplication.class, args);
	}
}
