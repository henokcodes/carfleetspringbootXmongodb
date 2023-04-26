package com.henokcodes.carfleet.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private String licensePlate;
    private String type;
    private String brand;
    private String color;
    private long price;


}
