package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 11/22/23
 **/
@SpringBootApplication
@EnableCassandraRepositories
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
