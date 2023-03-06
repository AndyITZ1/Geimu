package com.revature.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoGameDTO {
    private String name;
    private double price;
    private String description;
    private String console;
    private String edition;
}
