package org.nagyza.cardealer.controller;

import org.nagyza.cardealer.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(path = "/hello")
    public String getGreeting() {
        Car car = new Car("Toyota", "Corolla");
        return "Hello user \n You can buy a " + car.getBrand() + " " + car.getType();
    }
}
