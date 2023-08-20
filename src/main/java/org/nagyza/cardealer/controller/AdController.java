package org.nagyza.cardealer.controller;

import org.nagyza.cardealer.dto.AdDTO;
import org.nagyza.cardealer.dto.AdRequestDTO;
import org.nagyza.cardealer.model.Ad;
import org.nagyza.cardealer.service.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AdController {
    private final Logger logger = LoggerFactory.getLogger(AdController.class);

    private final AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping(path = "ad/{id}", produces = "application/json")
    public ResponseEntity<AdDTO> getAd(@PathVariable(name = "id") Long id) {

        logger.info("Get ad called. Id is: " + id);
        AdDTO ad = adService.getAdById(id);
        if (ad != null) {
            logger.info(ad.toString());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //todo
        }
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }

    @GetMapping(path = "ad/search", produces = "application/json")
    public ResponseEntity<List<String>> searchAd(@RequestParam(name = "query") String query) {
        return new ResponseEntity<>(adService.searchAds(query), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(path = "ad", consumes = "application/json", produces = "application/json")
    public ResponseEntity<URI> addAd(@RequestBody @Valid AdRequestDTO adRequestDTO) throws URISyntaxException {
        String adBasePath = "http://localhost:8080/ad/";
        Ad ad = adService.postAd(adRequestDTO);

        if (ad != null) {
            URI uri = new URI(adBasePath + ad.getId());
            return new ResponseEntity<>(uri ,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping(path = "ad/{id}")
    public ResponseEntity<?> deleteAd(@PathVariable(name = "id") Long id) throws Exception {
        adService.deleteAd(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
