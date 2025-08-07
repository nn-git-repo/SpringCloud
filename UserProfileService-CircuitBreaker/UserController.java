package com.connectly.userprofile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.connectly.userprofile.model.User;
import com.connectly.userprofile.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	 private final UserService userService;

	    // ✅ Manual constructor instead of @RequiredArgsConstructor
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	    @GetMapping("/{id}")
	    public User getUser(@PathVariable String id) {
	        return userService.getUserById(id);
	    }
}
