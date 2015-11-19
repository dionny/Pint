package com.pint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeDao employeeDao;
}
