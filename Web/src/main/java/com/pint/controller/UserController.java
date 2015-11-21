package com.pint.controller;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.pint.entity.Employee;
import com.pint.entity.Hospital;
import com.pint.security.User;
import com.pint.security.UserAuthentication;
import com.pint.security.UserRole;
import com.pint.security.UserService;
import com.pint.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.pint.repository.HospitalBaseRepository;
import com.pint.repository.UserRepository;

@RestController
public class UserController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/createemployee")
	@ResponseBody
	public String create(String email, String password, String firstName, String lastName, String phoneNo, String role, long hospitalId) {
		Employee employee = null;
		System.out.println("\n\n\n\n\nCreating1\n\n\n\n");
		try {
			Hospital hospital = hospitalRepository.get(hospitalId);
			employee = new Employee(email, password, firstName, lastName, phoneNo, role, hospital);
			System.out.println("\n\n\n\n\nCreating2\n\n\n\n");
			userService.createEmployee(employee);
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
			List<Employee> nurseList = userService.getAllNurses(hospitalId);
			
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
	public String delete(String username) {
		try {
			User user = new User(username);
			userRepository.delete(user);
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
			User user = userRepository.findByUsername(email);
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
			User user = userRepository.findOne(id);
			user.setUsername(email);
			userRepository.save(user);
		}
		catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

	@RequestMapping(value = "/api/users/current", method = RequestMethod.GET)
	public User getCurrent() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication instanceof UserAuthentication) {
			return ((UserAuthentication) authentication).getDetails();
		}
		return new User(authentication.getName()); //anonymous user support
	}

	@RequestMapping(value = "/api/users/current", method = RequestMethod.PATCH)
	public ResponseEntity<String> changePassword(@RequestBody final User user) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final User currentUser = userRepository.findByUsername(authentication.getName());

		if (user.getNewPassword() == null || user.getNewPassword().length() < 4) {
			return new ResponseEntity<String>("new password to short", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		final BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		if (!pwEncoder.matches(user.getPassword(), currentUser.getPassword())) {
			return new ResponseEntity<String>("old password mismatch", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		currentUser.setPassword(pwEncoder.encode(user.getNewPassword()));
		userRepository.save(currentUser);
		return new ResponseEntity<String>("password changed", HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/api/users/{user}/grant/role/{role}", method = RequestMethod.POST)
	public ResponseEntity<String> grantRole(@PathVariable User user, @PathVariable UserRole role) {
		if (user == null) {
			return new ResponseEntity<String>("invalid user id", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		user.grantRole(role);
		userRepository.save(user);
		return new ResponseEntity<String>("role granted", HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/api/users/{user}/revoke/role/{role}", method = RequestMethod.POST)
	public ResponseEntity<String> revokeRole(@PathVariable User user, @PathVariable UserRole role) {
		if (user == null) {
			return new ResponseEntity<String>("invalid user id", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		user.revokeRole(role);
		userRepository.save(user);
		return new ResponseEntity<String>("role revoked", HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/api/users", method = RequestMethod.GET)
	public Collection<User> list() {
        return CollectionUtils.iterableToCollection(userRepository.findAll());
	}

	// Private fields

    @Autowired
    private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private HospitalBaseRepository hospitalRepository;
}