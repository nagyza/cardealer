package org.nagyza.cardealer.service;

import org.nagyza.cardealer.dto.AdDTO;
import org.nagyza.cardealer.dto.AdRequestDTO;
import org.nagyza.cardealer.model.Ad;
import org.nagyza.cardealer.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdService {

    private final AdRepository adRepository;

    @Autowired
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public List<String> searchAds(String query) {
        List<Ad> ads = adRepository.searchAds(query);
        final String adBasePath = "http://localhost:8080/ad/";
        return ads.stream()
                .map(ad -> adBasePath + ad.getId())
                .collect(Collectors.toList());
    }

    public AdDTO getAdById(Long id) {

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
        return adRepository.save(new Ad(adRequestDTO.getBrand(), adRequestDTO.getType(),
                adRequestDTO.getDescription(), adRequestDTO.getPrice(), getUserDetails().getUsername()));
    }

    public void deleteAd(Long id) {
        UserDetails userDetails = getUserDetails();
        AdDTO ad = getAdById(id);
        boolean hasRightToDelete = ad != null && ad.getSeller().equals(userDetails.getUsername());
        if (hasRightToDelete) {
            adRepository.deleteById(id);
        } else {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "No right to delete this ad.");
        }
    }

    public static UserDetails getUserDetails() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
