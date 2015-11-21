package com.pint.repository;

import javax.transaction.Transactional;

import com.pint.entity.Employee;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
