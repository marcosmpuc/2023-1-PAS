package com.projarq.informationcollector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;

public class InformationController {

    private Logger logger = LoggerFactory.getLogger(InformationController.class);
    @Autowired
    private Environment environment;
    @Autowired
    private InformationControllerRep repository;

    @PostMapping("/information-collector-feign/from/{from}/to/{to}/quantity/{quantity}/value/{value}")
    public Information collectInformation(@PathVariable String from, @PathVariable String to,
                                          @PathVariable BigDecimal quantity, @PathVariable BigDecimal value){

        logger.info("collectInformation called with {} to {}", from, to);
        LocalDateTime lt = LocalDateTime.now();
        Information newInfo = new Information(from,to,quantity,value, lt);
        Information info = repository.save(newInfo);
        String port = environment.getProperty("local.server.port");
        info.setEnvironment(port);
        return info;
    }
}
