package com.example.assignment.repositories;

import com.example.assignment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findByUserId(Long userId);

    List<Appointment> findByDate(String date);

    @Query("SELECT a FROM Appointment a WHERE LOWER(a.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Appointment> searchByTitle(@Param("title") String title);

    @Query("SELECT a FROM Appointment a WHERE a.userId = :userId AND LOWER(a.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Appointment> searchByUserAndTitle(@Param("userId") Long userId, @Param("title") String title);

    @Modifying
    @Transactional
    @Query("UPDATE Appointment a SET a.time = :time WHERE a.id = :id")
    int updateTimeById(@Param("id") Long id, @Param("time") String time);
}