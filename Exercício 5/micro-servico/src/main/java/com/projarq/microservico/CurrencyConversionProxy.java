package com.projarq.microservico;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-conversion", url = "localhost:8000")
public interface CurrencyConversionProxy {
    @GetMapping("/currency-conversion/from/{from}/to/{to}")
    public Informacao retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
