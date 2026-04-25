package com.example.assignment.Repositories;


import com.example.assignment.model.Resources;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resources, Long> {

    @Query("SELECT r FROM Resources r WHERE r.name LIKE %:name%")
    List<Resources> findByNameContaining(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Resources r SET r.phoneNumber = :phone WHERE r.id = :id")
    int updatePhoneNumberById(@Param("id") Long id, @Param("phone") String phoneNumber);
}