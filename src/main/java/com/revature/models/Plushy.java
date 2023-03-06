package com.revature.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value = "PLUSHY")
@ToString(callSuper = true)
public class Plushy extends Product {
    private double height;
    private double weight;
    public Plushy(int id, String name, double price, String description, double height, double weight) {
        super(id, name, price, description);
        this.height = height;
        this.weight = weight;
    }
}
