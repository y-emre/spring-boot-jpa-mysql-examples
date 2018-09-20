package com.examples.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.examples.crud.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
