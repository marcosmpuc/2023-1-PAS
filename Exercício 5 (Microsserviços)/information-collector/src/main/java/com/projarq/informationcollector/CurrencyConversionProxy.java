package com.projarq.informationcollector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "currency-conversion", url = "localhost:8100")
public interface CurrencyConversionProxy {
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public Information retrieveConversionValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity);
}
