package com.Micro.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Micro.Model.ExchangeValue;
@Component
public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Integer>{
	
	ExchangeValue findByFromAndTo(String from, String to);

}
