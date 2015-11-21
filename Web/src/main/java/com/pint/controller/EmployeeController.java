package com.pint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pint.entity.Employee;
import com.pint.security.UserService;

@Controller
public class EmployeeController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/nurses")
	@ResponseBody
	public String getNurses(Long hospitalId) {
		String nurses = "";
		try {
			List<Employee> nurseList = userService.getAllNurses(hospitalId);
			if (nurseList != null){
				for (int i = 0; i < nurseList.size(); i++){
					nurses += " " + nurseList.get(i).getFirstName();
				}
			}
		}
		catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return nurses;
	}
}
