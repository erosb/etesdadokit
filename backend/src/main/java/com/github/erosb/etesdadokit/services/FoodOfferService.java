package com.github.erosb.etesdadokit.services;

import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRequest;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferResponse;

import java.util.List;

public interface FoodOfferService {

    FoodOfferResponse findById(Long id);

    List<FoodOfferResponse> getAllFoodOfferings();


    FoodOfferResponse createFoodOffer(FoodOfferRequest foodOfferRequest);
}
