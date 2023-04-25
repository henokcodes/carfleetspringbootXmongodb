package com.henokcodes.carfleet.Dto;

import lombok.Data;

@Data
public class CarDTO {

    private String licensePlate;
    private String type;
    private String Brand;
    private String price;
    private String amount;

    public CarDTO() {
    }

    public CarDTO(String licensePlate, String type, String Brand, String price, String amount) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.Brand = Brand;
        this.price = price;
        this.amount = amount;
    }
}
