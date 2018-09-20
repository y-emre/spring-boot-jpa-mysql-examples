package com.examples.validations.repository;

import org.springframework.data.repository.CrudRepository;

import com.examples.validations.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
