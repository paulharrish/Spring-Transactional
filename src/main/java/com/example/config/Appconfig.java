package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class Appconfig {

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/spring-transactional",
                "root", "F#7b9/Db");
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public TransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
