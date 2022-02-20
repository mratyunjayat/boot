package com.mt.example.boot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mt.example.boot.entities.User;
import com.mt.example.boot.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public User findUserByName(String name) {
		return userRepository.findByUserName(name);
	}
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
}
