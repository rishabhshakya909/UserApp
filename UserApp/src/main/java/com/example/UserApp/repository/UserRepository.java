package com.example.UserApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UserApp.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
