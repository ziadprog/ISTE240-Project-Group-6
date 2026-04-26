//Name: Ziad Abdelrahman
//ID: 764002985

package com.example.assignment.Repositories;

import com.example.assignment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName LIKE %:name%")
    List<User> findByUserNameContaining(@Param("name") String userName);

    User findByEmail(String email);

    User findByUserId(String userId);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.userName = :name WHERE u.id = :id")
    int updateUserNameById(@Param("id") Long id, @Param("name") String userName);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.email = :email WHERE u.id = :id")
    int updateEmailById(@Param("id") Long id, @Param("email") String email);
}
