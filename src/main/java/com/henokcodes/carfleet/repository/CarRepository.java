package com.henokcodes.carfleet.repository;

import com.henokcodes.carfleet.Domain.Car;
import com.henokcodes.carfleet.Dto.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    //find by type
    public Collection<Car> findByType(String type);
    //find by brand
    public Collection<Car> findByBrand(String brand);
    //find by price
    public Collection<Car> findByPrice(String price);
    //find by brand and type
    public Collection<Car> findByBrandAndType(String brand, String type);

    public Car findByLicensePlate(String licensePlate);
}
