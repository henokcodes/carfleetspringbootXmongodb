package com.henokcodes.carfleet.Domain;

import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cars")
public class Car {

    @Id
    private String id;
    private String licensePlate;

    private String type;
    private String brand;

    private String color;
    private long price;

   //set default value to true
    private boolean isAvailable= true;

    public Car(String licensePlate, String type, String brand, String color, long price) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public boolean getAvailable() {
        return isAvailable;
    }
}
