package com.spring.demo.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	private Logger logger=LogManager.getLogger(this.getClass());

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		logger.info("calculateCurrencyConversion called with {} to {} with {}",from ,to,quantity);

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean response=responseEntity.getBody();

		response.setQuantity(quantity);
		response.setTotalCalculatedAmount(response.getConversionMultiple().multiply(quantity));
		return response;

	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		logger.info("calculateCurrencyConversionfeign called with {} to {} with {}",from ,to,quantity);
		
		CurrencyConversionBean response=proxy.retrieveExchangeValue(from, to);

		response.setQuantity(quantity);
		response.setTotalCalculatedAmount(response.getConversionMultiple().multiply(quantity));
		
		logger.info("{}",response);
		
		return response;

	}

}
