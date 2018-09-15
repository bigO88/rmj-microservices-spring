package com.rmj.spring.etlservice.batch;

import com.rmj.spring.etlservice.model.SalesRecord;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class Processor implements ItemProcessor<SalesRecord,SalesRecord> {

    public Processor() {
    }

    @Override
    public SalesRecord process(SalesRecord salesRecord) {

        salesRecord.setTotalCost(salesRecord.getUnitCost()+salesRecord.getTotalProfit()+salesRecord.getTotalRevenue());
        return salesRecord;
    }
}
