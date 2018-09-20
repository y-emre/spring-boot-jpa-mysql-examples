package com.examples.callbackmethods.repository;

import org.springframework.data.repository.CrudRepository;

import com.examples.callbackmethods.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
