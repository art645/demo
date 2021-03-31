package com.example.testservice.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
@ImportResource("classpath:context.xml")
public class DataSourceConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return  new JdbcTemplate(dataSource);
    }
}
