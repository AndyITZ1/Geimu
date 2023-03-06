package com.revature.services;

import com.revature.dtos.UserResponseDTO;
import com.revature.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByCredentials(String email, String password);
    Optional<User> findByEmail(String email);
    Optional<User> findById(int id);
    UserResponseDTO createUser(User user);
    void updatePassword(User user, String password);
    String updateEmail(User user, String email);
    List<UserResponseDTO> getAllUsers();
    String deleteUserById(int id);
}
