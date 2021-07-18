package com.example.demo;

import com.example.demo.repository.GenusRepository;
import com.example.demo.service.GenusController;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "123"));

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        //GenusController.addGenus("Yucca");
    }
}
