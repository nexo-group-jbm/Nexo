package com.Micro.Proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Micro.Model.CurrencyConversionBean;
@Service
@FeignClient(name = "netflix-zuul-api-proxy")
@RibbonClient(name = "forex-service")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("forex-service/current/form/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);
}