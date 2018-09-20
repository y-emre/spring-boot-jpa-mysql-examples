package com.examples.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.examples.crud.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findByName(String name);
	
	List<Person> findByAge(int age);
	
}
