package com.example.helloworldapplication.Containers;

import org.testcontainers.containers.MySQLContainer;

public class SqlContainer extends MySQLContainer<SqlContainer> {

    public static final String IMAGE_VERSION = "mysql:8.0";
    public static final  String DATABASE_NAME = "test";

    public static MySQLContainer container ;


    public SqlContainer()
    {
        super(IMAGE_VERSION);
    }

    public static  MySQLContainer getInstance()
    {
        if(container == null)
        {
            container = new MySQLContainer().withDatabaseName(DATABASE_NAME);
        }
        return container;
    }

    @Override
    public void start()
    {
        super.start();
        System.setProperty("DB_URL" ,container.getJdbcUrl());
        System.setProperty("DB_USERNAME" , container.getUsername());
        System.setProperty("DB_PASSWORD" , container.getPassword());
    }

    @Override
    public void stop()
    {

    }
}
