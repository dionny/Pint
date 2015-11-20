package com.pint.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pint.entity.Employee;
import com.pint.entity.Hospital;
import com.pint.entity.User;
import com.pint.entity.repository.HospitalRepository;
import com.pint.entity.repository.UserDao;
import com.pint.entity.repository.UserRepository;

@Controller
public class UserController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/user")
	public User user(@RequestParam(value="username", defaultValue="team4") String username, @RequestParam(value="email", defaultValue="clarke@fiu.edu") String email) {
		return new User(counter.incrementAndGet(), username, email);
	}

	/**
	 * GET /create  --> Create a new user and save it in the database.
	 */
	@RequestMapping("/create")
	@ResponseBody
	public String create(String email, String name) {
		User user = null;
		try {
			user = new User(email, name);
			userDao.save(user);
		}
		catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created! (id = " + user.getId() + ")";
	}

	@RequestMapping("/createemployee")
	@ResponseBody
	public String create(String email, String password, String firstName, String lastName, String phoneNo, String role, long hospitalId) {
		Employee employee = null;
		System.out.println("\n\n\n\n\nCreating1\n\n\n\n");
		try {
			Hospital hospital = hospitalRepository.get(hospitalId);
			employee = new Employee(email, password, firstName, lastName, phoneNo, role, hospital);
			System.out.println("\n\n\n\n\nCreating2\n\n\n\n");
			userRepository.createEmployee(employee);
		}
		catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created! (id = " + employee.getEmailAddress() + ")";
	}
	
	@RequestMapping("/getnurses")
	@ResponseBody
	public String getNurses(long hospitalId){
		String nurses = "";
		
		try
		{
			List<Employee> nurseList = userRepository.getAllNurses(hospitalId);
			
			for (int i = 0; i < nurseList.size(); i++){
				nurses += "\n" + nurseList.get(i).getFirstName();
			}
		}
		catch (Exception ex){
			return "Error getting nurses\n";
		}
		
		return nurses;
	}


	/**
	 * GET /delete  --> Delete the user having the passed id.
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			User user = new User(id);
			userDao.delete(user);
		}
		catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

	/**
	 * GET /get-by-email  --> Return the id for the user having the passed
	 * email.
	 */
	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId;
		try {
			User user = userDao.findByEmail(email);
			userId = String.valueOf(user.getId());
		}
		catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}

	/**
	 * GET /update  --> Update the email and the name for the user in the 
	 * database having the passed id.
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String email, String name) {
		try {
			User user = userDao.findOne(id);
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		}
		catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

	// Private fields

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;

}