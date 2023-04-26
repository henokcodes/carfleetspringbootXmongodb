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
        System.out.println("************");
        System.out.println(carDTO);
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
        car.setColor(carDTO.getColor());
        car.setPrice(carDTO.getPrice());
        carRepository.save(car);
        return carDTO;
    }

    //get all cars
    public List<Car> getAllCars(){
        List<Car> cars =  carRepository.findAll();
        System.out.println(cars);

        return cars;
    }

    //get car by licensePlate
    public CarDTO getCarByLicensePlate(String licensePlate){
        Car car = carRepository.findByLicensePlate(licensePlate);
        CarDTO carDTO = carAdaptor.getCarDTO(car);
        return carDTO;
    }

    //get car by type
    public List<CarDTO> getCarsByType(String type){
        List<Car> car = carRepository.findByType(type);

        List<CarDTO> carDTO = (List<CarDTO>) carAdaptor.getAllCarDTOs(car);
        return carDTO;
    }
    //get car by brand
    public List<CarDTO> getCarsByBrand(String brand){
        List<Car> car = carRepository.findByBrand(brand);
        List<CarDTO> carDTO = (List<CarDTO>) carAdaptor.getAllCarDTOs(car);
        return carDTO;
    }
    //get car by price
    public List<CarDTO> getCarsByPrice(String price){
        List<Car> car = carRepository.findByPrice(price);
        List<CarDTO> carDTO = (List<CarDTO>) carAdaptor.getAllCarDTOs(car);
        return carDTO;
    }





}
