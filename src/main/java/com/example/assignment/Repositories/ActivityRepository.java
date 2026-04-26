//Name: Ziad Abdelrahman
//ID: 764002985
package com.example.assignment.repositories;

import com.example.assignment.model.Activity;
import com.example.assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByUserId(Long userId);

    List<Activity> findAll();

    @Query("SELECT a FROM Activity a WHERE a.user.id = :userId AND LOWER(a.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Activity> findByUserAndTitle(@Param("userId") Long userId, @Param("title") String title);

    @Modifying
    @Transactional
    @Query("UPDATE Activity a SET a.title = :title, a.category = :category, a.description = :description, a.date = :date, a.duration = :duration, a.user = :user WHERE a.id = :id")
    int updateActivityById(@Param("id") Long id,
                           @Param("title") String title,
                           @Param("category") String category,
                           @Param("description") String description,
                           @Param("date") String date,
                           @Param("duration") String duration,
                           @Param("user") User user);

    void deleteById(Long id);
}
