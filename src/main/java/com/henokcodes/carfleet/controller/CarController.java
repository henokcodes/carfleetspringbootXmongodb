package com.henokcodes.carfleet.controller;

import com.henokcodes.carfleet.Domain.Car;
import com.henokcodes.carfleet.Dto.CarDTO;
import com.henokcodes.carfleet.service.CarService;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;
    //get all cars
    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }


    //get car by type
    @GetMapping("/search")
    public List<CarDTO> getCarByKey(@RequestParam String key, @RequestParam String value){
        if(key.equals("type"))
        return carService.getCarsByType(value);
        else if(key.equals("brand"))
        return carService.getCarsByBrand(value);
        else if(key.equals("price"))
        return carService.getCarsByPrice(value);
        else return null;

    }
    @GetMapping("/{licensePlate}")
    public CarDTO getCarByKey(@PathVariable String licensePlate){
            return carService.getCarByLicensePlate(licensePlate);
    }

    //add car
    @PostMapping
    public CarDTO addCar(@RequestBody CarDTO carDTO){
        return carService.addCar(carDTO);
    }
    //update car
    @PutMapping
    public CarDTO updateCar(@RequestBody CarDTO carDTO){
        return carService.updateCar(carDTO);
    }
    //remove car
    @DeleteMapping("/{licensePlate}")
    public void removeCar(@PathVariable String licensePlate){
        carService.removeCar(licensePlate);
    }





}
