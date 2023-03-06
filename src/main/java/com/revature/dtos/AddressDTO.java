package com.revature.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    @NotNull(message = "Please enter in street address.")
    private String street;
    private String state;
    private String city;
    @NotNull(message = "Please enter in a country.")
    private String country;
    private String zipCode;
}
