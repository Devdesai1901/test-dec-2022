package com.example.helloworldapplication;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testcontainers.containers.MySQLContainer;

import javax.sql.DataSource;

public class DatabaseTest {
    @Test
    public void testDatabaseConnection() {
        try (MySQLContainer<?> container = new MySQLContainer<>("mysql:latest")
                .withUsername("root")
                .withPassword("desai")
                .withDatabaseName("test")) {

            container.start();

            // Get the database connection properties
            String jdbcUrl = container.getJdbcUrl();
            String username = container.getUsername();
            String password = container.getPassword();

            // Create a DataSource using the container's connection properties
            DataSource dataSource = createDataSource(jdbcUrl, username, password);

            // Create a JdbcTemplate using the DataSource
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            // Perform your database tests or operations here
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))");

            // Stop and cleanup the container
            container.stop();
        }
    }

    private DataSource createDataSource(String jdbcUrl, String username, String password) {
        return DataSourceBuilder.create()
                .url(jdbcUrl)
                .username(username)
                .password(password)
                .build();
    }
}