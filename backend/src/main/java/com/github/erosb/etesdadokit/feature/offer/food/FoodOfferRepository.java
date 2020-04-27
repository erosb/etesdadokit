package com.github.erosb.etesdadokit.feature.offer.food;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FoodOfferRepository extends JpaRepository<FoodOfferEntity, Long> {

    List<FoodOfferEntity> findByTransportDate(LocalDate day);

    List<FoodOfferEntity> findByIngredientsContainingIgnoreCase(String ingredient);


}

