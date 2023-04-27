package com.henokcodes.carfleet.service;

import com.henokcodes.carfleet.Dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

public class ReservationListener {

    @Autowired
    private CarService carService;

    @JmsListener(destination = "reserved-queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        CarDTO carDTO = carService.getCarByLicensePlate(message);
        carDTO.setAvailable(false);
        carService.updateCar(carDTO);
    }

    @JmsListener(destination = "returned-queue")
    public void returnedMessage(String message) {
        System.out.println("Received message: " + message);
        CarDTO carDTO = carService.getCarByLicensePlate(message);
        carDTO.setAvailable(true);
        carService.updateCar(carDTO);
    }

}
