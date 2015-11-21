package com.pint.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.pint.entity.Employee;

@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
