package com.engsoft2.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@FeignClient(name = "currency-collector", url = "localhost:8080")
public interface InformationCollectorProxy {

    @PostMapping("/information-collector-feign/from/{from}/to/{to}/quantity/{quantity}/value/{value}")
    public CurrencyConversion collectInformation(@PathVariable String from, @PathVariable String to,
                                                 @PathVariable BigDecimal quantity,@PathVariable BigDecimal value);
}
