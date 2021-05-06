package com.spring.microservices.currrencyexchangeservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger logger=LogManager.getLogger(this.getClass());

	@GetMapping("/sample-api")
	//@Retry(name = "sample-api",fallbackMethod ="hardCodedResponse")
	//@CircuitBreaker(name = "default",fallbackMethod ="hardCodedResponse")
	@RateLimiter(name="default")
	public String sampleAPI() {
		
		logger.info("Sample API Call");
		
//		ResponseEntity<String> entity= new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);

		
		
		//return entity.getBody();
		
		return "sample-api";
	}
	
	public String hardCodedResponse(Exception e) {
		return "fallback-response";
	}

}
