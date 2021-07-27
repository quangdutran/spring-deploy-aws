package com.aws.cicd.demo;

import javassist.NotFoundException;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSrcConfig {
    @Bean
    public DataSource getDataSource() throws NotFoundException {
        String HOST_NAME = System.getenv("RDS_HOSTNAME");
        String RDS_PORT = System.getenv("RDS_PORT");
        String RDS_DB_NAME = System.getenv("RDS_DB_NAME");
        String USER_NAME = System.getenv("RDS_USERNAME");
        String RDS_PASSWORD = System.getenv("RDS_PASSWORD");
        if (HOST_NAME != null && RDS_PASSWORD != null && RDS_DB_NAME != null
                && RDS_PORT != null && USER_NAME != null) {
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
            dataSourceBuilder.url("jdbc:mysql://" + HOST_NAME + ":" + RDS_PORT + "/" + RDS_DB_NAME);
            dataSourceBuilder.username(USER_NAME);
            dataSourceBuilder.password(RDS_PASSWORD);
            return dataSourceBuilder.build();
        } else {
            throw new NotFoundException("Could not find RDS hostname");
        }
    }
}
