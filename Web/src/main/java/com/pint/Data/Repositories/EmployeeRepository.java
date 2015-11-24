package com.pint.Data.Repositories;

import javax.transaction.Transactional;

import com.pint.Data.Models.Employee;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
