package com.example.assignment.repositories;

import com.example.assignment.model.Diary;
import com.example.assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//Shahid Rizwan-415004364
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    List<Diary> findByUserId(Long userId);

    List<Diary> findAll();

    @Query("SELECT d FROM Diary d WHERE d.user.id = :userId AND LOWER(d.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Diary> findByUserAndTitle(@Param("userId") Long userId, @Param("title") String title);

    @Modifying
    @Transactional
    @Query("UPDATE Diary d SET d.title = :title, d.content = :content, d.date = :date, d.user = :user WHERE d.id = :id")
    void updateDiaryById(@Param("id") Long id,
                          @Param("title") String title,
                          @Param("content") String content,
                          @Param("date") String date,
                          @Param("user") User user);

    void deleteById(Long id);
}