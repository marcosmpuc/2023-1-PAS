package com.projarq.microservico;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationCollectorController implements InformationCollectorProxy {
    
    //@Autowired
    //InformationRepository repository;

    @PostMapping(path = "/information-collector", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Information saveExchangeInformation(@RequestAttribute("moeda") String moeda, @RequestAttribute("valor") BigDecimal valor) {
        Information information = new Information()
            .moeda(moeda)
            .valor(valor)
            .quantidade(new BigDecimal(1))
            .dataHora(LocalDateTime.now());
        //repository.save(information);
        return information;
    }
}
