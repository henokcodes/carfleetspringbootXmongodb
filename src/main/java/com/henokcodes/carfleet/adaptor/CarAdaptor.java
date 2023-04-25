package com.henokcodes.carfleet.adaptor;

import com.henokcodes.carfleet.Domain.Car;
import com.henokcodes.carfleet.Dto.CarDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CarAdaptor {

    // get CarDTO from Car
    public CarDTO getCarDTO(Car car){
        return new CarDTO(car.getLicensePlate(), car.getType(), car.getBrand(), car.getPrice(), car.getAmount());
    }
    //get Car from CarDTO
    public Car getCar(CarDTO carDTO){
        return new Car(carDTO.getLicensePlate(), carDTO.getType(), carDTO.getBrand(), carDTO.getPrice(), carDTO.getAmount());
    }
    //get all cars from all CarDTOs
    public Collection<Car> getAllCars(Collection<CarDTO> carDTOs){
           Collection<Car> cars = null;
            for (CarDTO carDTO : carDTOs) {
                cars.add(getCar(carDTO));
            }
            return cars;
    }
    //get all CarDTOs from all cars
    public Collection<CarDTO> getAllCarDTOs(Collection<Car> cars){

        Collection<CarDTO> carDTOs = null;
        for (Car car : cars) {
            carDTOs.add(getCarDTO(car));
        }
        return carDTOs;
    }

}
