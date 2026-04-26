//Name: Ziad Abdelrahman
//ID: 764002985

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
