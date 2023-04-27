package com.henokcodes.carfleet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableMongoRepositories
@EnableJms
public class CarfleetApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarfleetApplication.class, args);
	}

}
