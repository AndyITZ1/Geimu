package com.revature.controllers;

import com.revature.dtos.UserResponseDTO;
import com.revature.exceptions.EmailAlreadyUsedException;
import com.revature.exceptions.OldPasswordException;
import com.revature.exceptions.SameEmailUsedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }

    @PutMapping("/user/{id}/password")
    public ResponseEntity<Void> updatePassword(@PathVariable int id, @RequestBody String password) {
        Optional<User> userOptional = userService.findById(id);
        userOptional.orElseThrow(UserNotFoundException::new);
        User user = userOptional.get();
        if (user.getPassword().equals(password))
            throw new OldPasswordException();
        userService.updatePassword(user, password);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/user/{id}/email")
    public ResponseEntity<String> updateEmail(@PathVariable int id, @RequestBody String email) {
        Optional<User> userOptional = userService.findById(id);
        userOptional.orElseThrow(UserNotFoundException::new);
        Optional<User> emailOptional = userService.findByEmail(email);
        if (emailOptional.isPresent()) {
            if (userOptional.get().equals(emailOptional.get()))
                throw new SameEmailUsedException();
            else
                throw new EmailAlreadyUsedException();
        }
        User user = userOptional.get();
        return ResponseEntity.ok(userService.updateEmail(user, email));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
