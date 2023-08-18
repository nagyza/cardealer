package org.nagyza.cardealer.controller;

import org.nagyza.cardealer.model.Ad;
import org.nagyza.cardealer.repository.AdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    Logger logger = LoggerFactory.getLogger(GreetingController.class);

    private final AdRepository adRepository;

    @Autowired
    public GreetingController(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Ad>> getGreeting() {

        logger.info("Get called on /");
        return new ResponseEntity<>(adRepository.findAll(), HttpStatus.OK);
    }
}
