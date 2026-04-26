package com.example.assignment.repositories;

import com.example.assignment.model.Resources;
import com.example.assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resources, Long> {

    List<Resources> findByUserId(Long userId);

    List<Resources> findAll();

    @Query("SELECT r FROM Resources r WHERE r.user.id = :userId AND LOWER(r.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Resources> findByUserAndName(@Param("userId") Long userId, @Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Resources r SET r.name = :name, r.type = :type, r.description = :description, r.website = :website, r.user = :user WHERE r.id = :id")
    void updateResourceById(@Param("id") Long id,
                           @Param("name") String name,
                           @Param("type") String type,
                           @Param("description") String description,
                           @Param("website") String website,
                           @Param("user") User user);

    void deleteById(Long id);
}