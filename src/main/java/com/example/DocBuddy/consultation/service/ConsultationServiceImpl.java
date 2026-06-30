package com.example.DocBuddy.consultation.service;

import com.example.DocBuddy.appointment.entity.Appointment;
import com.example.DocBuddy.appointment.repo.AppointmentRepo;
import com.example.DocBuddy.consultation.dto.ConsultationDTO;
import com.example.DocBuddy.consultation.entity.Consultation;
import com.example.DocBuddy.consultation.repo.ConsultationRepo;
import com.example.DocBuddy.enums.AppointmentStatus;
import com.example.DocBuddy.exceptions.BadRequestException;
import com.example.DocBuddy.exceptions.NotFoundException;
import com.example.DocBuddy.patient.entity.Patient;
import com.example.DocBuddy.patient.repo.PatientRepo;
import com.example.DocBuddy.res.Response;
import com.example.DocBuddy.users.entity.User;
import com.example.DocBuddy.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ConsultationServiceImpl implements ConsultationService{


    private final ConsultationRepo consultationRepo;
    private final AppointmentRepo appointmentRepo;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final PatientRepo patientRepo;

    @Override
    public Response<ConsultationDTO> createConsultation(ConsultationDTO consultationDTO) {

        User user = userService.getCurrentUser();
        Long appointmentId = consultationDTO.getAppointmentId();

        Appointment appointment = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new NotFoundException("Appointment not found."));

        // Security Check 1: Must be the doctor linked to the appointment
        if (!appointment.getDoctor().getUser().getId().equals(user.getId())) {
            throw new BadRequestException("You are not authorized to create notes for this consultation.");
        }
        // Complete the appointment
        appointment.setStatus(AppointmentStatus.COMPLETED);
        appointmentRepo.save(appointment);

        // Check 3: Ensure a consultation doesn't already exist for this appointment
        if (consultationRepo.findByAppointmentId(appointmentId).isPresent()) {
            throw new BadRequestException("Consultation notes already exist for this appointment.");
        }

        Consultation consultation = Consultation.builder()
                .consultationDate(LocalDateTime.now())
                .subjectiveNotes(consultationDTO.getSubjectiveNotes())
                .objectiveFindings(consultationDTO.getObjectiveFindings())
                .assessment(consultationDTO.getAssessment())
                .plan(consultationDTO.getPlan())
                .appointment(appointment)
                .build();

        consultationRepo.save(consultation);

        return Response.<ConsultationDTO>builder()
                .statusCode(200)
                .message("Consultation notes saved successfully.")
                .build();

    }

    @Override
    public Response<ConsultationDTO> getConsultationByAppointmentId(Long appointmentId) {

        User user = userService.getCurrentUser();

        Consultation consultation = consultationRepo.findByAppointmentId(appointmentId)
                .orElseThrow(() -> new NotFoundException("Consultation notes not found for appointment ID: " + appointmentId));


        return Response.<ConsultationDTO>builder()
                .statusCode(200)
                .message("Consultation notes retrieved successfully.")
                .data(modelMapper.map(consultation, ConsultationDTO.class))
                .build();

    }

    @Override
    public Response<List<ConsultationDTO>> getConsultationHistoryForPatient(Long patientId) {

        User user = userService.getCurrentUser();

        // 1. If patientId is null, retrieve the ID of the current authenticated patient.
        if (patientId == null) {
            Patient currentPatient = patientRepo.findByUser(user)
                    .orElseThrow(() -> new BadRequestException("Patient profile not found for the current user"));
            patientId = currentPatient.getId();
        }

        // Find the patient to ensure they exist (or to perform future security checks)
        patientRepo.findById(patientId)
                .orElseThrow(() -> new NotFoundException("Patient not found "));


        // Use the repository method to fetch all consultations linked via appointments
        List<Consultation> history = consultationRepo.findByAppointmentPatientIdOrderByConsultationDateDesc(patientId);

        if (history.isEmpty()) {
            return Response.<List<ConsultationDTO>>builder()
                    .statusCode(200)
                    .message("No consultation history found for this patient.")
                    .data(List.of())
                    .build();
        }

        List<ConsultationDTO> historyDTOs = history.stream()
                .map(consultation -> modelMapper.map(consultation, ConsultationDTO.class))
                .toList();

        return Response.<List<ConsultationDTO>>builder()
                .statusCode(200)
                .message("Consultation history retrieved successfully.")
                .data(historyDTOs)
                .build();

    }
}