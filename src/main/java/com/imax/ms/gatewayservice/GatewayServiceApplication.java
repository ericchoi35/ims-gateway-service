package com.imax.ms.gatewayservice;

import com.imax.ms.gatewayservice.filters.ErrorFilter;
import com.imax.ms.gatewayservice.filters.PostFilter;
import com.imax.ms.gatewayservice.filters.PreFilter;
import com.imax.ms.gatewayservice.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@Configuration
@EnableHystrixDashboard
@EnableCircuitBreaker
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
