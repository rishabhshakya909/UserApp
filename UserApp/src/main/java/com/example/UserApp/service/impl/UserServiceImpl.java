package com.example.UserApp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.UserApp.entity.User;
import com.example.UserApp.repository.UserRepository;
import com.example.UserApp.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public User updateUser(Integer id, User user) {
		Optional<User> existing = userRepository.findById(id);
		if(existing.isPresent()) {
			User u = existing.get();
			u.setName(user.getName());
            u.setAge(user.getAge());
            u.setEmail(user.getEmail());
            u.setPhoneNo(user.getPhoneNo());
            u.setAddress(user.getAddress());
            return userRepository.save(u);
		}
		return null;
	}

	@Override
	public boolean deleteUser(Integer id) {
		if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
	}
	
}
