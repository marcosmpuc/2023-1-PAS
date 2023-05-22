package com.projarq.microservico;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@FeignClient(name = "information-collector", url = "localhost:8080")
public interface InformationCollectorProxy {

    @PostMapping(path = "/information-collector", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Information saveExchangeInformation(@RequestAttribute("moeda") String moeda, @RequestAttribute("valor") BigDecimal valor);
}
