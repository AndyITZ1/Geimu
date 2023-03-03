package com.revature.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("2")
public class Plushy extends Product {
    @Column(nullable = false)
    private double height;
    @Column(nullable = false)
    private double weight;
}
