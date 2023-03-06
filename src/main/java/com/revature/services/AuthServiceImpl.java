package com.revature.services;

import com.revature.dtos.AddressDTO;
import com.revature.dtos.UserResponseDTO;
import com.revature.models.Address;
import com.revature.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final AddressService addressService;

    public Optional<User> findByCredentials(String email, String password) {
        return userService.findByCredentials(email, password);
    }
    public Optional<User> findUserByEmail(String email) {
        return userService.findByEmail(email);
    }

    public Optional<Address> findAddressByAll(AddressDTO addressDTO) {
        Address address = new Address(0,
                addressDTO.getStreet(),
                addressDTO.getCity(),
                addressDTO.getState(),
                addressDTO.getCountry(),
                addressDTO.getZipCode()
        );
        return addressService.findByAll(address);
    }

    public UserResponseDTO register(User user) {
        return userService.createUser(user);
    }



}
