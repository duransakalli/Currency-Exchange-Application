package com.drn.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrentExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {

        CurrentExchange currentExchange = repository.findByFromAndTo(from, to);
        if(Objects.isNull(currentExchange)) {
            throw new RuntimeException("Unable to find data");
        }
        String port = environment.getProperty("local.server.port");
        currentExchange.setEnvironment(port);
        return currentExchange;
    }

}
