package com.henokcodes.carfleet.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "cars")
public class Car {

    @Id
    @Generated
    private String id;
    @Indexed(unique = true)
    private String licensePlate;
    private String type;
    private String Brand;
    private String price;
    private int amount;

    public Car(String licensePlate, String type, String brand, String price, int amount) {
    }
}
