package com.revature.services;

import com.revature.dtos.AddressDTO;
import com.revature.dtos.UserResponseDTO;
import com.revature.models.Address;
import com.revature.models.User;

import java.util.Optional;

public interface AuthService {
    Optional<User> findByCredentials(String email, String password);
    Optional<User> findUserByEmail(String email);
    Optional<Address> findAddressByAll(AddressDTO addressDTO);
    UserResponseDTO register(User user);
}
