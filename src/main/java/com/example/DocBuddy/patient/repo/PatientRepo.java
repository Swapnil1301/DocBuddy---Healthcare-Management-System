package com.example.DocBuddy.patient.repo;

import com.example.DocBuddy.patient.entity.Patient;
import com.example.DocBuddy.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient, Long> {

    Optional<Patient> findByUser(User user);
}
