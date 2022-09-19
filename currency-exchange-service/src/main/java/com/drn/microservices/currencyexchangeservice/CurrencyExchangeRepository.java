package com.drn.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrentExchange, Long> {

    CurrentExchange findByFromAndTo(String from, String to);

}
