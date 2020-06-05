package com.example.database;



import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.database.entity.Person;
import com.example.database.jpa.PersonJpaRepository;


@SpringBootApplication
public class SpringJpaDatabaseDemoApplication2 implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDatabaseDemoApplication2.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//logger.info("Users by id - {}", dao.findById(10001));
		
		logger.info("inserting user id 10004 - {}", repository.insert(new Person(10004, "John", "Berlin", new Date()))) ;
		logger.info("Updating user id 10003 - {}", repository.update(new Person(10003, "Ben", "East coast", new Date())));
		logger.info("user by id - {}", repository.findById(1));
		logger.info("All users - {}", repository.findAll());
		//repository.deleteById(1);
	}

}
