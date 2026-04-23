package com.example.assignment.services;

import com.example.assignment.model.User;
import com.example.assignment.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User searchByEmail(String email) {
        return userRepository.searchByEmail(email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public int updatePassword(Long id, String password) {
        return userRepository.updatePasswordById(id, password);
    }
}