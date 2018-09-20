package com.examples.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.examples.crud.model.Firm;

public interface FirmRepository extends CrudRepository<Firm, Long> {

}
