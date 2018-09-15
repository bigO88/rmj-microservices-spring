package com.rmj.spring.etlservice.batch;

import com.rmj.spring.etlservice.model.SalesRecord;
import com.rmj.spring.etlservice.repository.SalesRecordRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<SalesRecord> {

    @Autowired
    SalesRecordRepository salesRecordRepository;

    @Override
    public void write(List<? extends SalesRecord> salesRecords) throws Exception {
        salesRecordRepository.saveAll(salesRecords);
    }
}
