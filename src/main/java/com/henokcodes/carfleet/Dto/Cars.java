package com.henokcodes.carfleet.Dto;

import com.henokcodes.carfleet.Domain.Car;

import java.util.ArrayList;
import java.util.Collection;

public class Cars {
        private Collection<CarDTO> cars = new ArrayList<CarDTO>();

        public Cars() {
        }

        public Cars(Collection<CarDTO> cars) {
                this.cars = cars;
        }

        public Collection<CarDTO> getCars() {
                return cars;
        }

        public void setCars(Collection<CarDTO> cars) {
                this.cars = cars;
        }

}
