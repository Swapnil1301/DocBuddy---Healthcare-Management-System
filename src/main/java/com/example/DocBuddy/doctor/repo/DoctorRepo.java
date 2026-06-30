package com.example.DocBuddy.doctor.repo;

import com.example.DocBuddy.doctor.entity.Doctor;
import com.example.DocBuddy.enums.Specialization;
import com.example.DocBuddy.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {

    Optional<Doctor> findByUser(User user);

    List<Doctor> findBySpecialization(Specialization specialization);

}