package com.projarq.microservico;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InformacaoController {
    private Logger logger = LoggerFactory.getLogger(InformacaoController.class);

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public Information retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        return proxy.retrieveExchangeValue(from, to);
    }

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public Information calculateCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
        ResponseEntity<Information> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", Information.class, uriVariables);
        return new Information()
            .moeda(responseEntity.getBody().getMoeda())
            .quantidade(responseEntity.getBody().getQuantidade())
            .valor(responseEntity.getBody().getValor())
            .dataHora(responseEntity.getBody().getDataHora());
    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public Information calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        return calculateCurrencyConversion(from, to, quantity);
    }
}
