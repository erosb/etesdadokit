package com.github.erosb.etesdadokit.feature.offer.material;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MaterialOfferRepository extends JpaRepository<MaterialOfferEntity, Long> {

    List<MaterialOfferEntity> findByOfferDate(LocalDate offerDate);
}
