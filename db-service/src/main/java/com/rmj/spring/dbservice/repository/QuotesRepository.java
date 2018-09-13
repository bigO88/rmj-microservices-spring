package com.rmj.spring.dbservice.repository;

import com.rmj.spring.dbservice.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotesRepository extends JpaRepository<Quote,Integer> {

    List<Quote> findByUserName(String username);

}
