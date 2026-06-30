package com.example.DocBuddy.appointment.service;

import com.example.DocBuddy.appointment.dto.AppointmentDTO;
import com.example.DocBuddy.res.Response;

import java.util.List;

public interface AppointmentService {

    Response<AppointmentDTO> bookAppointment(AppointmentDTO appointmentDTO);

    Response<List<AppointmentDTO>> getMyAppointments();

    Response<AppointmentDTO> cancelAppointment(Long appointmentId);

    Response<?> completeAppointment(Long appointmentId);

}