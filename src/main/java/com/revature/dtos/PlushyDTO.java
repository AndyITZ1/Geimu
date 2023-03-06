package com.revature.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlushyDTO {
    private String name;
    private double price;
    private String description;
    private double height;
    private double weight;
}
