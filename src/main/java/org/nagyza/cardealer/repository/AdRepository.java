package org.nagyza.cardealer.repository;

import org.nagyza.cardealer.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

    @Query("SELECT a FROM ads a WHERE " +
            "a.brand LIKE CONCAT('%',:query, '%')" +
            "Or a.type LIKE CONCAT('%', :query, '%')")
    List<Ad> searchAds(String query);

}
