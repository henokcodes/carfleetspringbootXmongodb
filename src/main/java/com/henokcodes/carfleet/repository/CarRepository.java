package com.henokcodes.carfleet.repository;

import com.henokcodes.carfleet.Domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    //find by type
    public List<Car> findByType(String type);
    //find by brand
    public List<Car> findByBrand(String brand);
    //find by price
    public List<Car> findByPrice(String price);

    public Car findByLicensePlate(String licensePlate);
}
