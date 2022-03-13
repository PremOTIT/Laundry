package com.cg.dryclean.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dryclean.entity.User;
import com.cg.dryclean.exception.RecordNotFoundException;
import com.cg.dryclean.service.IUserService;
import com.cg.dryclean.utility.GlobalResources;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService iUserService;
	private Logger logger = GlobalResources.getLogger(IUserService.class);

	@PostMapping("/users")
	public User signIn(@RequestBody User user) throws RecordNotFoundException {
		String methodName = "signIn()";
		logger.info(methodName + "Called");
		BCryptPasswordEncoder bcrpt = new BCryptPasswordEncoder();
		String encodePwd = bcrpt.encode(user.getPassword());
		user.setPassword(encodePwd);
		return iUserService.signIn(user);
	}

	@DeleteMapping("/users")
	public User signOut(@RequestBody User user) throws RecordNotFoundException {
		String methodName = "signOut()";
		logger.info(methodName + "Called");
		return iUserService.signOut(user);
	}

	@PutMapping("/users")
	public User changePassword(@RequestBody User user) throws RecordNotFoundException {
		String methodName = "changePassword()";
		logger.info(methodName + "Called");
		BCryptPasswordEncoder bcrpt = new BCryptPasswordEncoder();
		String encodePwd = bcrpt.encode(user.getPassword());
		user.setPassword(encodePwd);
		return iUserService.changePassword(user);
	}

}
