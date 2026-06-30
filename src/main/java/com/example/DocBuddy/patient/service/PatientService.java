package com.example.DocBuddy.patient.service;

import com.example.DocBuddy.enums.BloodGroup;
import com.example.DocBuddy.enums.Genotype;
import com.example.DocBuddy.patient.dto.PatientDTO;
import com.example.DocBuddy.res.Response;

import java.util.List;

public interface PatientService {


    Response<PatientDTO> getPatientProfile();

    Response<?> updatePatientProfile(PatientDTO patientDTO);

    Response<PatientDTO> getPatientById(Long patientId);

    Response<List<BloodGroup>> getAllBloodGroupEnums();
    Response<List<Genotype>>getAllGenotypeEnums();

}