//package com.spring.demo.currencyconversionservice;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.cloud.client.DefaultServiceInstance;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import reactor.core.publisher.Flux;
//
//@Configuration
//public class CurrencyExchangeConfiguration {
//
//	@Bean
//	@Primary
//	ServiceInstanceListSupplier serviceInstanceListSupplier() {
//		return new CurrencyExchangeServiceSupplier("currency-exchange-service");
//	}
//	
//}
//
//class CurrencyExchangeServiceSupplier implements ServiceInstanceListSupplier{
//
//	private final String serviceId;
//	
//	
//	
//	public CurrencyExchangeServiceSupplier(String serviceId) {
//		super();
//		this.serviceId = serviceId;
//	}
//
//	@Override
//	public Flux<List<ServiceInstance>> get() {
//		// TODO Auto-generated method stub
//		return Flux.just(Arrays.asList(new DefaultServiceInstance(serviceId+1, serviceId, "localhost", 8000, false),
//				new DefaultServiceInstance(serviceId+1, serviceId, "localhost", 8001, false)));
//	}
//
//	@Override
//	public String getServiceId() {
//		// TODO Auto-generated method stub
//		return serviceId;
//	}
//	
//}
