package org.nagyza.cardealer.controller;

import org.nagyza.cardealer.model.Car;
import org.nagyza.cardealer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class GreetingController {

    CarRepository carRepository;

    @Autowired
    public GreetingController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping(path = "/hello")
    public List<Car> getGreeting() {

        return carRepository.findAll();
    }
}
