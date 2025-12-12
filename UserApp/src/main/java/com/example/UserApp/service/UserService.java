package com.example.UserApp.service;

import java.util.List;
import java.util.Optional;

import com.example.UserApp.entity.User;

public interface UserService {
	User createUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(Integer id);
    User updateUser(Integer id, User user);
    boolean deleteUser(Integer id);
	
	
}
