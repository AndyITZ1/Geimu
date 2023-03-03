package com.revature.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @Email(regexp = ".+@.+\\..+", message = "Please enter in a valid email address.")
    private String email;
    @NotNull(message = "Please enter in a password.")
    private String password;
}
