package com.rmj.spring.etlservice.repository;

import com.rmj.spring.etlservice.model.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRecordRepository extends JpaRepository<SalesRecord,Integer> {


}
