package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Manager;
import com.springboot.main.model.User;
import com.springboot.main.service.ManagerService;
import com.springboot.main.service.MyUserService;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerService managerService; 
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MyUserService userService; 
	@PostMapping("/add")
	public Manager postManager(@RequestBody Manager manager) {
		/*Read user info given as input and attach it to user object.  */
		User user = manager.getUser();
		user.setRole("MANAGER");
		
		/* Encode the password before saving in DB */
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		/* Save user in DB and fetch saved object */
		user = userService.insert(user);
		
		/* attach user to manager */
		manager.setUser(user);
		
		/* Save manager in DB */
		return managerService.insert(manager);
	}
}
