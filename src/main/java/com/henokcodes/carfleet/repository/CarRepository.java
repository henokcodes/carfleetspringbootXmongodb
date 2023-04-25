package com.henokcodes.carfleet.repository;

import com.henokcodes.carfleet.Domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    //find by type
    public Car findByType(String type);
    //find by brand
    public Car findByBrand(String brand);
    //find by price
    public Car findByPrice(String price);
}
