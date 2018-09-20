package com.examples.entitylistener.repository;

import org.springframework.data.repository.CrudRepository;

import com.examples.entitylistener.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
