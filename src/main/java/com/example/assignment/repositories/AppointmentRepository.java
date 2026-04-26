package com.example.assignment.repositories;
//Shahid Rizwan-415004364
import com.example.assignment.model.Appointment;
import com.example.assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByUserId(Long userId);

    List<Appointment> findAll();

    @Query("SELECT a FROM Appointment a WHERE a.user.id = :userId AND LOWER(a.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Appointment> findByUserAndTitle(@Param("userId") Long userId, @Param("title") String title);

    @Modifying
    @Transactional
    @Query("UPDATE Appointment a SET a.title = :title, a.description = :description, a.date = :date, a.time = :time, a.user = :user WHERE a.id = :id")
    void updateAppointmentById(@Param("id") Long id,
                              @Param("title") String title,
                              @Param("description") String description,
                              @Param("date") String date,
                              @Param("time") String time,
                              @Param("user") User user);

    void deleteById(Long id);
}