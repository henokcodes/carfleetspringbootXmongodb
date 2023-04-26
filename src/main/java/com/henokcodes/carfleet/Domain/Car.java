package com.henokcodes.carfleet.Domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cars")
public class Car {

    @Id
    @Generated
    private String id;
    @NonNull
    @Indexed(unique = true)
    private String licensePlate;
    @NonNull
    private String type;
    @NonNull
    private String brand;

    @NonNull
    private String color;
    @NonNull
    private long price;

    public Car(String licensePlate, String type, String brand, String color, long price) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
}
