package com.spring.microservice.demo.springcloudgatewayserver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayConfiguration {
	
	private Logger logger=LogManager.getLogger(this.getClass());
	
	@Bean
	public RouteLocator gateWayRoute(RouteLocatorBuilder builder) {
		
		logger.info("{}",builder);
		
		return builder.routes()
				.route("currency-exchange-service",r->r.path("/currency-exchange/**")
						.uri("lb://currency-exchange-service")
						)
				.route("currency-exchange-service",r->r.path("/currency-converter-feign/**")
						.uri("lb://currency-conversion-service")
						)
				
				.route(r->r.path("/currency-converter-new/**")
						.filters(f->f.rewritePath("/currency-converter-new/(?<segment>.*)",
								"/currency-converter-feign/${segment}"))
						.uri("lb://currency-conversion-service")
						)
				
				
				
				
				
				.build();
		
	}

}
