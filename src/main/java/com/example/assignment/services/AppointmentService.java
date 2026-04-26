package com.example.assignment.services;

import com.example.assignment.model.Appointment;
import com.example.assignment.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//Shahid Rizwan-415004364
@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> getByUserId(Long userId) {
        return appointmentRepository.findByUserId(userId);
    }

    public List<Appointment> findByUserAndTitle(Long userId, String title) {
        return appointmentRepository.findByUserAndTitle(userId, title);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public void updateAppointment(Long id, Appointment appointment) {
        appointmentRepository.updateAppointmentById(
                id,
                appointment.getTitle(),
                appointment.getDescription(),
                appointment.getDate(),
                appointment.getTime(),
                appointment.getUser()
        );
    }
}