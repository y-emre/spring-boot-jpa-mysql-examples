package com.examples.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.examples.crud.model.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
