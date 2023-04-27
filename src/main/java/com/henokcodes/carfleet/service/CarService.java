package com.henokcodes.carfleet.service;

import com.henokcodes.carfleet.Domain.Car;
import com.henokcodes.carfleet.Dto.Cars;
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
    public Cars getAllCars(){
        Collection<Car> cars = carRepository.findAll();

        Collection<CarDTO> carDTO =  carAdaptor.getAllCarDTOs(cars);
        Cars allCars = new Cars(carDTO);
        return allCars;

    }

    //get car by licensePlate
    public CarDTO getCarByLicensePlate(String licensePlate){
        Car car = carRepository.findByLicensePlate(licensePlate);
        CarDTO carDTO = carAdaptor.getCarDTO(car);

        return carDTO;
    }

    //get car by type
    public Cars getCarsByType(String type){
        Collection<Car> car = carRepository.findByType(type);

        Collection<CarDTO> carDTO =  carAdaptor.getAllCarDTOs(car);
        Cars cars = new Cars(carDTO);
        return cars;

    }
    //get car by brand
    public Cars getCarsByBrand(String brand){
        Collection<Car> car = carRepository.findByBrand(brand);

        Collection<CarDTO> carDTO =  carAdaptor.getAllCarDTOs(car);
        Cars cars = new Cars(carDTO);
        return cars;
    }
    //get car by price
    public Cars getCarsByPrice(String price){
        Collection<Car> car = carRepository.findByPrice(price);

        Collection<CarDTO> carDTO =  carAdaptor.getAllCarDTOs(car);
        Cars cars = new Cars(carDTO);
        return cars;
    }
    //get car by brand and type
    public Cars getCarsByBrandAndType(String brand, String type){
        Collection<Car> car = carRepository.findByBrandAndType(brand, type);

        Collection<CarDTO> carDTO =  carAdaptor.getAllCarDTOs(car);
        Cars cars = new Cars(carDTO);
        return cars;
    }





}
