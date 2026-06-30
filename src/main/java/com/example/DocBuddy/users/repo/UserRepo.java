package com.example.DocBuddy.users.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DocBuddy.users.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
