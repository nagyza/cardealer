package org.nagyza.cardealer.service;

import org.nagyza.cardealer.dto.AdDTO;
import org.nagyza.cardealer.dto.AdRequestDTO;
import org.nagyza.cardealer.model.Ad;
import org.nagyza.cardealer.repository.AdRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdService {

    Logger logger = LoggerFactory.getLogger(AdService.class);
    private final AdRepository adRepository;

    @Autowired
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public List<Ad> getAllAds() {
        return List.of();
    }

    public List<Ad> searchAds(String searchTerm) {
        return List.of();
    }

    public AdDTO getAd(Long id) {

        Optional<Ad> byId = adRepository.findById(id);

        AdDTO result;
        if (byId.isPresent()) {
            Ad ad = byId.get();

            result = new AdDTO(ad.getId(), ad.getBrand(), ad.getType(), ad.getDescription(), ad.getPrice(), ad.getSeller());

        } else {
            result = null;
        }

        return result;
    }

    public Ad postAd(AdRequestDTO adRequestDTO) {
        logger.info(adRequestDTO.toString());
        return adRepository.save(new Ad(adRequestDTO.getBrand(), adRequestDTO.getType(), adRequestDTO.getDescription(), adRequestDTO.getPrice(), "user"));
    }

    public void deleteAd(Long id) throws Exception {

    }

    public Ad updateAd(Ad ad) {
        return ad;
    }
}
