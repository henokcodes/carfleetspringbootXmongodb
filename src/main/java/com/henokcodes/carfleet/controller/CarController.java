package com.henokcodes.carfleet.controller;

import com.henokcodes.carfleet.Domain.Car;
import com.henokcodes.carfleet.Dto.Cars;
import com.henokcodes.carfleet.Dto.CarDTO;
import com.henokcodes.carfleet.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public  ResponseEntity<?> getAllCars(){
        Cars cars =  carService.getAllCars();
        return new ResponseEntity<Cars>(cars, HttpStatus.OK);
    }


    //get car by type
    @GetMapping("/search")
    public ResponseEntity<?> getCarByKey(@RequestParam String brand, @RequestParam String type){

        return new ResponseEntity<Cars>(carService.getCarsByBrandAndType(brand,type), HttpStatus.OK);

    }
    @GetMapping("/{licensePlate}")
    public ResponseEntity<?> getCarByKey(@PathVariable String licensePlate){
            return new ResponseEntity<CarDTO>(carService.getCarByLicensePlate(licensePlate), HttpStatus.OK);
    }

    //add car
    @PostMapping
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO){
        return new ResponseEntity<CarDTO>(carService.addCar(carDTO), HttpStatus.CREATED);
    }
    //update car
    @PutMapping
    public ResponseEntity<?> updateCar(@RequestBody CarDTO carDTO){
        return new ResponseEntity<CarDTO>(carService.updateCar(carDTO), HttpStatus.OK);
    }
    //remove car
    @DeleteMapping("/{licensePlate}")
    public void removeCar(@PathVariable String licensePlate){
        carService.removeCar(licensePlate);
    }





}
