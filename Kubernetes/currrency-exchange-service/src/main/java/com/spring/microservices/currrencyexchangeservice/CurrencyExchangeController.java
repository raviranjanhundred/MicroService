package com.spring.microservices.currrencyexchangeservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	private Logger logger=LogManager.getLogger(this.getClass());
	
	@Autowired
	private ExchangeValueRespository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
	

		logger.info("retrieveExchangeValue called with {} to {}",from,to);
		
		ExchangeValue exchangeValue=repository.findByFromAndTo(from, to);
		
		String port=environment.getProperty("local.server.port");
		
		String host=environment.getProperty("HOSTNAME","");
		String version="v2";
		
		exchangeValue.setEnvironment(port+" "+version+" "+host);
		

		logger.info("{}",exchangeValue);
		
		return exchangeValue;
	}

}
