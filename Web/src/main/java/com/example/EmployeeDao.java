package com.example;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Long>{

}
