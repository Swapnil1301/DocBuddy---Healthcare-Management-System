package com.example.DocBuddy.consultation.service;

import com.example.DocBuddy.consultation.dto.ConsultationDTO;
import com.example.DocBuddy.res.Response;

import java.util.List;

public interface ConsultationService {

    Response<ConsultationDTO> createConsultation(ConsultationDTO consultationDTO);

    Response<ConsultationDTO> getConsultationByAppointmentId(Long appointmentId);

    Response<List<ConsultationDTO>> getConsultationHistoryForPatient(Long patientId);

}
