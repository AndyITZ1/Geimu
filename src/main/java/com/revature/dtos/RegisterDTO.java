package com.revature.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    @NotNull(message = "Please enter in your first name.")
    private String firstName;
    @NotNull(message = "Please enter in your last name.")
    private String lastName;
    @NotNull(message = "Please enter in a password.")
    private String password;
    @Email(regexp = ".+@.+\\..+", message = "Please enter in a valid email address.")
    private String email;
    @NotNull
    private AddressDTO address;
}
