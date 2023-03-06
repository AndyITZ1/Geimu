package com.revature.models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Entity
@DiscriminatorValue(value = "VIDEO GAME")
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class VideoGame extends Product {
    private String console;
    private String edition;
    public VideoGame(int id, String name, double price, String description, String console, String edition) {
        super(id, name, price, description);
        this.console = console;
        this.edition = edition;
    }
}
