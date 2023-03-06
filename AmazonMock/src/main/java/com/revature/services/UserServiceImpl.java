package com.revature.services;

import com.revature.dtos.AddressDTO;
import com.revature.dtos.UserResponseDTO;
import com.revature.exceptions.DeleteUserFailedException;
import com.revature.models.User;
import com.revature.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@Transactional
//public class UserService implements UserServiceInterface {
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserResponseDTO createUser(User user) {
        User savedUser = userRepository.save(user);
        AddressDTO addressDTO = new AddressDTO(
                savedUser.getAddress().getStreet(),
                savedUser.getAddress().getState(),
                savedUser.getAddress().getCity(),
                savedUser.getAddress().getCountry(),
                savedUser.getAddress().getZipCode()
        );
        UserResponseDTO userResponseDTO = new UserResponseDTO(
                savedUser.getId(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getEmail(),
                addressDTO
        );
        return userResponseDTO;
    }
    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void updatePassword(User user, String password) {
        user.setPassword(password);
    }

    @Transactional
    public String updateEmail(User user, String email) {
        user.setEmail(email);
        return user.getEmail();
    }

    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            AddressDTO addressDTO = new AddressDTO(
                    user.getAddress().getStreet(),
                    user.getAddress().getState(),
                    user.getAddress().getCity(),
                    user.getAddress().getCountry(),
                    user.getAddress().getZipCode()
            );
            userDTOs.add(new UserResponseDTO(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail(),
                    addressDTO
            ));
        }
        return userDTOs;
    }

    public String deleteUserById(int id) throws DeleteUserFailedException {
        userRepository.deleteById(id);
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent())
            throw new DeleteUserFailedException(userOptional.get().getId(), userOptional.get().getEmail());
        return "User #" + id + " was successfully deleted.";
    }
}
