package org.nagyza.cardealer.repository;

import org.nagyza.cardealer.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
    List<Ad> findByBrand(String brand);

}
