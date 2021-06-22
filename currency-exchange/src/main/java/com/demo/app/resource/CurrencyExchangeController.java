package com.demo.app.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeJpaRepository repository;
	
	
	@RequestMapping(value = "/currenyExchange/{from}/to/{to}", method = RequestMethod.GET)
	public ResponseEntity<ExchangeValue> getExchangeValue(@PathVariable String from, @PathVariable String to) {

		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		if (exchangeValue == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return new ResponseEntity<ExchangeValue>(exchangeValue, HttpStatus.ACCEPTED);
	}
}
