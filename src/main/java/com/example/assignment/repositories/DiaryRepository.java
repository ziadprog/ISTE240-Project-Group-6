package com.example.assignment.repositories;

import com.example.assignment.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

    List<Diary> findByTitle(String title);

    List<Diary> findByUserId(Long userId);

    @Query("SELECT d FROM Diary d WHERE LOWER(d.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Diary> searchByTitle(@Param("title") String title);

    @Query("SELECT d FROM Diary d WHERE d.userId = :userId AND LOWER(d.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Diary> searchByUserAndTitle(@Param("userId") Long userId, @Param("title") String title);

    @Modifying
    @Transactional
    @Query("UPDATE Diary d SET d.content = :content WHERE d.id = :id")
    int updateContentById(@Param("id") Long id, @Param("content") String content);
}