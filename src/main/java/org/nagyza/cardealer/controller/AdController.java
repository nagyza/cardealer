package org.nagyza.cardealer.controller;

import org.nagyza.cardealer.dto.AdDTO;
import org.nagyza.cardealer.model.Ad;
import org.nagyza.cardealer.service.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AdController {
    Logger logger = LoggerFactory.getLogger(AdController.class);

    private final AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping(path = "ad/{id}")
    public ResponseEntity<AdDTO> getAd(@PathVariable(name = "id") Long id) {

        logger.info("Get ad called. Id is: " + id);
        AdDTO ad = adService.getAd(id);
        logger.info(ad.toString());
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }

    @GetMapping(path = "ad/search")
    public ResponseEntity<List<String>> searchAd(String term) {
        return null;
    }

}
