package com.pint.entity.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.pint.entity.Employee;

@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Long>{

}
