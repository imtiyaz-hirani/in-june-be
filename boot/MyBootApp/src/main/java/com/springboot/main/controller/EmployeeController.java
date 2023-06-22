package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Employee;
import com.springboot.main.model.Manager;
import com.springboot.main.model.User;
import com.springboot.main.service.EmployeeService;
import com.springboot.main.service.ManagerService;
import com.springboot.main.service.MyUserService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private PasswordEncoder encoder; 
	
	@Autowired
	private MyUserService userService; 
	
	@Autowired
	private EmployeeService employeeService; 
	
	@Autowired
	private ManagerService managerService; 
	
	@PostMapping("/add/{managerId}")
	public ResponseEntity<?> addEmployee(@PathVariable("managerId") int managerId, 
			@RequestBody Employee employee) {
		/* validate managerId and fetch manager obj from DB */
		Manager manager  = managerService.getById(managerId);
		if(manager == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Manager ID invalid");
		
		/* attach manager to employee */
		employee.setManager(manager);
		
		/* Fetch the user from employee */
		User user = employee.getUser();
		
		/* Encode the password given as Plain text from UI */
		user.setPassword(encoder.encode(user.getPassword()));
		
		/* Set the role: EMPLOYEE */
		user.setRole("EMPLOYEE");
		
		/* Save the user in DB */
		user  = userService.insert(user);
		
		/* Attach user to employee and save employee */
		employee.setUser(user);
		employee =  employeeService.insert(employee);
		return ResponseEntity.status(HttpStatus.OK)
				.body(employee);
	}
}
