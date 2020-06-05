package com.example.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.database.entity.Person;

//Repository
@Repository
//Transaction
@Transactional
public class PersonJpaRepository {
	
	//connect to database - enetityManager is a interface to persistenceContext
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return entityManager.merge(person);
		//checks for id if id is present update the record, if id not present inserts the record
	}
	
	public Person insert(Person person) {
		return entityManager.merge(person);
		//checks for id if id is present update the record, if id not present inserts the record
	}
	
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all", Person.class);
		return namedQuery.getResultList();
	}
	
}
