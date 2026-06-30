package com.example.DocBuddy.users.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DocBuddy.users.entity.PasswordResetCode;

public interface PasswordResetRepo extends JpaRepository<PasswordResetCode, Long> {
	Optional<PasswordResetCode> findByCode(String code);
	void deleteByUserId(Long userId);
}

