package com.mt.example.boot.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.example.boot.entities.User;
import com.mt.example.boot.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserResources {

	private final UserService userService;

	@GetMapping("")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/find-by-name/{name}")
	public User findByUserName(@PathVariable(name = "name") String userName) {
		return userService.findUserByName(userName);
	}
	
	@PostMapping("/add")
	public User addUser(User user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/update")
	public User updateUser(User user) {
		return userService.addUser(user);
	}
}
