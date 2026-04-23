package com.example.assignment.controllers;

import com.example.assignment.model.Appointment;
import com.example.assignment.services.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/api/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/api/appointments/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id).orElse(null);

        if (appointment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(appointment);
    }

    @GetMapping("/api/appointments/search")
    public List<Appointment> searchAppointments(@RequestParam String title) {
        return appointmentService.searchByTitle(title);
    }

    @GetMapping("/api/appointments/user/{userId}")
    public List<Appointment> getAppointmentsByUser(@PathVariable Long userId) {
        return appointmentService.getByUserId(userId);
    }

    @GetMapping("/api/appointments/user/{userId}/search")
    public List<Appointment> searchUserAppointments(@PathVariable Long userId, @RequestParam String title) {
        return appointmentService.searchByUserAndTitle(userId, title);
    }

    @PostMapping("/api/appointments")
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.saveAppointment(appointment));
    }

    @PutMapping("/api/appointments/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        Appointment existingAppointment = appointmentService.getAppointmentById(id).orElse(null);

        if (existingAppointment == null) {
            return ResponseEntity.notFound().build();
        }

        existingAppointment.setTitle(updatedAppointment.getTitle());
        existingAppointment.setDescription(updatedAppointment.getDescription());
        existingAppointment.setDate(updatedAppointment.getDate());
        existingAppointment.setTime(updatedAppointment.getTime());
        existingAppointment.setUserId(updatedAppointment.getUserId());

        return ResponseEntity.ok(appointmentService.saveAppointment(existingAppointment));
    }

    @DeleteMapping("/api/appointments/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.ok("Appointment deleted");
    }
}