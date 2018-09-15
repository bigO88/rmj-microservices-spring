package com.rmj.spring.etlservice.config;


import com.rmj.spring.etlservice.model.SalesRecord;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


@Configuration
@EnableBatchProcessing
public class BatchConfig {


    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<SalesRecord> itemReader,
                   ItemProcessor<SalesRecord, SalesRecord> itemProcessor,
                   ItemWriter<SalesRecord> itemWriter) {

        Step step = stepBuilderFactory.get("ETL-Load-CSV")
                .<SalesRecord, SalesRecord>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("ETL-Load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    public FlatFileItemReader<SalesRecord> itemReader(@Value("${input}") org.springframework.core.io.Resource resource) {

        FlatFileItemReader<SalesRecord> flatFileItemReader = new FlatFileItemReader<>();

        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("CSV Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
    }

    @Bean
    public LineMapper<SalesRecord> lineMapper() {
        DefaultLineMapper<SalesRecord> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("Region","Country","ItemType","SalesChannel","OrderPriority","OrderDate","OrderID","ShipDate","UnitsSold","UnitPrice","UnitCost","TotalRevenue","TotalCost","TotalProfit");
        BeanWrapperFieldSetMapper<SalesRecord> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(SalesRecord.class);
        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }
}
