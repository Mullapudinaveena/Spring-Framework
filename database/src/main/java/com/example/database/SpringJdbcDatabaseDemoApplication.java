package com.example.database;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.database.entity.Person;
import com.example.database.jdbc.PersonJdbcDAO;

//@SpringBootApplication
public class SpringJdbcDatabaseDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users - {}", dao.findAll());
		logger.info("Users by id - {}", dao.findById(10001));
		logger.info("Deleted Users by id-10002 - {}", dao.deleteById(10002));
		logger.info("inserting user id 10004 - {}", dao.insert(new Person(10004, "John", "Berlin", new Date())));
		logger.info("Updating user id 10003 - {}", dao.update(new Person(10003, "Ben", "London", new Date())));
	}

}
