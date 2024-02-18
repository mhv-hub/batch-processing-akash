package com.bank.app.batch.config.job_defination.data_validation.reader;

import com.bank.app.domain.staging.entities.StgAccount;
import com.bank.app.domain.staging.entities.StgCustomer;
import jakarta.persistence.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataReader {

    private static final Logger LOGGER= LoggerFactory.getLogger(CustomerDataReader.class);


    EntityManagerFactory stagingEntityManagerFactory;

    public CustomerDataReader(@Qualifier("stagingEntityManagerFactory") EntityManagerFactory stagingEntityManagerFactory) {
        this.stagingEntityManagerFactory = stagingEntityManagerFactory;
    }


    @Bean(name = "stgCustomerReader")
    JpaCursorItemReader<StgCustomer> stgCustomerReader() {
        LOGGER.info("Inside stgCustomerReader()");
        return new JpaCursorItemReaderBuilder<StgCustomer>()
                .name("stgCustomerReader")
                .entityManagerFactory(stagingEntityManagerFactory)
                .queryString("From StgCustomer")
                .build();
    }
}