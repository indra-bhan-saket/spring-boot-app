package com.demo.app.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeJpaRepository extends JpaRepository<ExchangeValue, Integer> {

	public ExchangeValue findByFromAndTo(String from, String to);
}
