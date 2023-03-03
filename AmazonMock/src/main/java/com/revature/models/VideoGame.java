package com.revature.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@DiscriminatorValue("1")
@NoArgsConstructor
@AllArgsConstructor
public class VideoGame extends Product {
    @Column(nullable = false)
    private String console;
    private String edition;
}
