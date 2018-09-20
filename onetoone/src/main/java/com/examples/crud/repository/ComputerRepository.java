package com.examples.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.examples.crud.model.Computer;

public interface ComputerRepository extends CrudRepository<Computer, Long> {

}
