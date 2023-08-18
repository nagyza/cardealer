package org.nagyza.cardealer.service;

import org.nagyza.cardealer.dto.AdDTO;
import org.nagyza.cardealer.model.Ad;
import org.nagyza.cardealer.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdService {

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

    public void postAd(Ad ad) {

    }

    public void deleteAd(Long id) throws Exception {

    }

    public Ad updateAd(Ad ad) {
        return ad;
    }
}
