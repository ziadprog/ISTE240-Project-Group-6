//Name: Ziad Abdelrahman
//ID: 764002985

package com.example.assignment.Repositories;

import com.example.assignment.model.SelfAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<SelfAssessment, Long> {

    @Query("SELECT a FROM SelfAssessment a WHERE a.username LIKE %:username%")
    List<SelfAssessment> findByUsernameContaining(@Param("username") String username);
}
