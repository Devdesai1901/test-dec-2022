package com.example.helloworldapplication.config;

import com.example.helloworldapplication.Containers.SqlContainer;
import com.mysql.cj.jdbc.integration.c3p0.MysqlConnectionTester;
import org.junit.Test;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

@Testcontainers
public class ContainersEnvironment {


    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Container
    public static MySQLContainer mySQLContainer  = SqlContainer.getInstance();

}
