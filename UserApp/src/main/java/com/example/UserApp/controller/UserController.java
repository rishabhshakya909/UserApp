package com.example.UserApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserApp.entity.User;
import com.example.UserApp.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
	
	
//	private User user;
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
//	List<User> users = new ArrayList<User>();
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable Integer id){
		return userService.getUserById(id);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
	
	
	
	
	
}
