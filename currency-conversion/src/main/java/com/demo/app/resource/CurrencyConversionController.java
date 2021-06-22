package com.demo.app.resource;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@RequestMapping(value = "/currency-conversion/{from}/to/{to}/amount/{amountToConvert}", method=RequestMethod.GET)
	public ResponseEntity<CurrencyConversionBean> getConvertedCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable String amountToConvert) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:3333/currenyExchange/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);

		if (responseEntity == null || responseEntity.getBody() == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(responseEntity.getBody().getId(),
				from, amountToConvert, responseEntity.getBody().getConversionRate(),
				new BigDecimal(amountToConvert).multiply(new BigDecimal(responseEntity.getBody().getConversionRate())),
				responseEntity.getBody().getPort());
		return new ResponseEntity<>(currencyConversionBean, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/currency-conversion/feign/{from}/to/{to}/amount/{amountToConvert}", method = RequestMethod.GET)
	public ResponseEntity<CurrencyConversionBean> getConvertedCurrencyByFeignClient(@PathVariable String from,
			@PathVariable String to, @PathVariable String amountToConvert) {
		ResponseEntity<CurrencyConversionBean> responseEntity = currencyExchangeProxy.getExchangeValue(from, to);
		CurrencyConversionBean currencyConversionBean = new CurrencyConversionBean(responseEntity.getBody().getId(),
				from, amountToConvert, responseEntity.getBody().getConversionRate(),
				new BigDecimal(amountToConvert).multiply(new BigDecimal(responseEntity.getBody().getConversionRate())),
				responseEntity.getBody().getPort());
		return new ResponseEntity<>(currencyConversionBean, HttpStatus.ACCEPTED);
	}

}
