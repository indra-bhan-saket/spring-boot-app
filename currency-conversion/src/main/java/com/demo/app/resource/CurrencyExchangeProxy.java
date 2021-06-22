/**
 * 
 */
package com.demo.app.resource;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author isaket
 *
 */
//@FeignClient(name = "currency-exchange", url = "http://localhost:3333")
@FeignClient(name = "netflix-zuul-api-gateway")
@RibbonClient(name = "currency-exchange")
public interface CurrencyExchangeProxy {

	//@GetMapping(value = "/currenyExchange/{from}/to/{to}")
	@GetMapping(value = "/currency-exchange/currenyExchange/{from}/to/{to}")
	public ResponseEntity<CurrencyConversionBean> getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
