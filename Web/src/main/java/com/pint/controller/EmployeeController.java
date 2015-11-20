package com.pint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pint.entity.repository.EmployeeDao;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
}
