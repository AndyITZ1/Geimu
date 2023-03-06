package com.revature.controllers;

import com.revature.dtos.LoginDTO;
import com.revature.dtos.RegisterDTO;
import com.revature.dtos.UserResponseDTO;
import com.revature.exceptions.EmailAlreadyUsedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Address;
import com.revature.models.User;
import com.revature.services.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody @Valid LoginDTO loginDTO, HttpSession session) {
        Optional<User> userOptional = authService.findByCredentials(loginDTO.getEmail(), loginDTO.getPassword());
        userOptional.orElseThrow(UserNotFoundException::new);

        session.setAttribute("user", userOptional.get());
        return ResponseEntity.ok(userOptional.get());
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return ResponseEntity.ok("Nobody is logged in!");
        }
        session.removeAttribute("user");
        return ResponseEntity.ok("Successfully logged out!");
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterDTO registerDTO) {
        Optional<User> emailCheck = authService.findUserByEmail(registerDTO.getEmail());
        if (emailCheck.isPresent()) {
            throw new EmailAlreadyUsedException();
        }
        Optional<Address> addressCheck = authService.findAddressByAll(registerDTO.getAddress());
        Address address;
        if (!addressCheck.isPresent()) {
            address = new Address(0,
                    registerDTO.getAddress().getStreet(),
                    registerDTO.getAddress().getCity(),
                    registerDTO.getAddress().getState(),
                    registerDTO.getAddress().getCountry(),
                    registerDTO.getAddress().getZipCode()
            );
        }
        else
            address = addressCheck.get();
        User user = new User(0,
                registerDTO.getFirstName(),
                registerDTO.getLastName(),
                registerDTO.getPassword(),
                registerDTO.getEmail(),
                address
        );
        return ResponseEntity.ok(authService.register(user));
    }
}
