package com.example.assignment.services;

import com.example.assignment.model.Appointment;
import com.example.assignment.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Appointment> getByDate(String date) {
        return appointmentRepository.findByDate(date);
    }

    public List<Appointment> searchByTitle(String title) {
        return appointmentRepository.searchByTitle(title);
    }

    public List<Appointment> searchByUserAndTitle(Long userId, String title) {
        return appointmentRepository.searchByUserAndTitle(userId, title);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

    public int updateTime(Long id, String time) {
        return appointmentRepository.updateTimeById(id, time);
    }
}