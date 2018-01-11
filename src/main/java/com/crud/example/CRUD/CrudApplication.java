package com.crud.example.CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories("com.crud.example.CRUD.user.mongo")
@SpringBootApplication
public class CrudApplication{


	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
