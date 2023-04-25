package com.henokcodes.carfleet.service;

import com.henokcodes.carfleet.Domain.Car;
import com.henokcodes.carfleet.Dto.CarDTO;
import com.henokcodes.carfleet.adaptor.CarAdaptor;
import com.henokcodes.carfleet.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarAdaptor carAdaptor;


    //add car
    public CarDTO addCar(CarDTO carDTO){
        Car car = carAdaptor.getCar(carDTO);
        carRepository.save(car);
        return carDTO;
    }
    //remove car
    public void removeCar(String licensePlate){
        Car car = carRepository.findByLicensePlate(licensePlate);
        carRepository.delete(car);
    }
    //update car
    public CarDTO updateCar(CarDTO carDTO){
        Car car = carRepository.findByLicensePlate(carDTO.getLicensePlate());
        car.setType(carDTO.getType());
        car.setBrand(carDTO.getBrand());
        car.setPrice(carDTO.getPrice());
        car.setAmount(carDTO.getAmount());
        carRepository.save(car);
        return carDTO;
    }

    //get all cars
    public Collection<CarDTO> getAllCars(){
        Collection<Car> cars =  carRepository.findAll();
        Collection<CarDTO> carDTOs = carAdaptor.getAllCarDTOs(cars);
        return carDTOs;
    }

    //get car by licensePlate
    public CarDTO getCarByLicensePlate(String licensePlate){
        Car car = carRepository.findByLicensePlate(licensePlate);
        CarDTO carDTO = carAdaptor.getCarDTO(car);
        return carDTO;
    }

    //get car by type
    public CarDTO getCarByType(String type){
        Car car = carRepository.findByType(type);
        CarDTO carDTO = carAdaptor.getCarDTO(car);
        return carDTO;
    }
    //get car by brand
    public CarDTO getCarByBrand(String brand){
        Car car = carRepository.findByBrand(brand);
        CarDTO carDTO = carAdaptor.getCarDTO(car);
        return carDTO;
    }
    //get car by price
    public CarDTO getCarByPrice(String price){
        Car car = carRepository.findByPrice(price);
        CarDTO carDTO = carAdaptor.getCarDTO(car);
        return carDTO;
    }

    //get car amount by licensePlate
    public int getCarAmountByLicensePlate(String licensePlate){
        Car car = carRepository.findByLicensePlate(licensePlate);
        return car.getAmount();
    }



}
