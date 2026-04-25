package com.example.assignment.Services;

import com.example.assignment.model.User;
import com.example.assignment.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> searchByUserName(String name) {
        return userRepository.findByUserNameContaining(name);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    // Get all
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    // Get by id
//    public User getUserById(Long id) {
//        return userRepository.findById(id).orElse(null);
//    }
//
//    // Search by name
//    public List<User> searchByUserName(String name) {
//        return userRepository.findByUserNameContaining(name);
//    }
//
//    // Get by email
//    public User getUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    // Get by userId
//    public User getUserByUserId(String userId) {
//        return userRepository.findByUserId(userId);
//    }
//
//    // Create
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//    // Update
//    public User updateUser(Long id, User user) {
//        user.setId(id);
//        return userRepository.save(user);
//    }
//
//    // Delete
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//
//    // Update user name
//    public int updateUserName(Long id, String name) {
//        return userRepository.updateUserNameById(id, name);
//    }
//
//    // Update email
//    public int updateEmail(Long id, String email) {
//        return userRepository.updateEmailById(id, email);
//    }
//}