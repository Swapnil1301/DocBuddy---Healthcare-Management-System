package com.example.DocBuddy.doctor.service;

import com.example.DocBuddy.doctor.dto.DoctorDTO;
import com.example.DocBuddy.enums.Specialization;
import com.example.DocBuddy.res.Response;

import java.util.List;

public interface DoctorService {


    Response<DoctorDTO> getDoctorProfile();
    Response<?>updateDoctorProfile(DoctorDTO doctorDTO);
    Response<List<DoctorDTO>> getAllDoctors();
    Response<DoctorDTO> getDoctorById(Long doctorId);

    Response<List<DoctorDTO>> searchDoctorsBySpecialization(Specialization specialization);
    Response<List<Specialization>> getAllSpecializationEnums();

}
