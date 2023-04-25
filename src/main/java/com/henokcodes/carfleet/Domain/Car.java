package com.henokcodes.carfleet.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "cars")
public class Car {

    @Id
    private String licensePlate;
    private String type;
    private String Brand;
    private String price;
    private String amount;

}
