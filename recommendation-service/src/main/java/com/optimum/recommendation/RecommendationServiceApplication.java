package com.optimum.recommendation;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.client.RestTemplate;

import com.optimum.recommendation.interceptor.HttpHeaderInterceptor;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class RecommendationServiceApplication {

	@Autowired
	HttpHeaderInterceptor headerInterceptor;
	
	@Autowired
	RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(RecommendationServiceApplication.class, args);
	}

	@PostConstruct
	public void setupInterceptors() {
		restTemplate.getInterceptors().add(headerInterceptor);
	}
}
