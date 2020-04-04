package com.github.erosb.etesdadokit.feature.offer.food;

import java.util.List;

public interface FoodOfferService {

    FoodOfferResponse findById(Long id);

    List<FoodOfferResponse> getAllFoodOfferings();

    FoodOfferResponse createFoodOffer(FoodOfferRequest foodOfferRequest);
}
