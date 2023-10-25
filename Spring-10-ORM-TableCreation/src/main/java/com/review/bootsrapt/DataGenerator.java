package com.review.bootsrapt;

import com.review.entity.Car;
import com.review.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Car c1 = new Car("BMW","M5");
        Car c2 = new Car("Honda","Civic");
        Car c3 = new Car("Toyota","Corolla");

        // save those object to DB
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
    }
}
// CommandLineRunner interface whenever app execute, create method whatever we have inside of the method.