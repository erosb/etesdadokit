package com.github.erosb.etesdadokit.mapper;

import com.github.erosb.etesdadokit.domain.FoodOffer;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRequest;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferResponse;
import org.springframework.stereotype.Component;

@Component
public class FoodOfferMapper {

    public FoodOfferResponse foodOfferToResponse(FoodOffer foodOffer) {

        if (foodOffer == null){
            return null;
        }

        FoodOfferResponse response = FoodOfferResponse.builder()
                .id(foodOffer.getId())
                .name(foodOffer.getName())
                .portion(foodOffer.getPortion())
                .deliveryDate(foodOffer.getDeliveryDate())
                .notes(foodOffer.getNotes())
                .needTransport(foodOffer.getNeedTransport())
                .address(foodOffer.getAddress())
                .contactInfo(foodOffer.getContactInfo())
                .build();

        return response;
    }

    public FoodOffer foodOfferRequestToFoodOffer(FoodOfferRequest request) {
        if (request == null) {
            return null;
        }

        FoodOffer offer = FoodOffer.builder()
                .id(request.getId())
                .name(request.getName())
                .portion(request.getPortion())
                .deliveryDate(request.getDeliveryDate())
                .notes(request.getNotes())
                .needTransport(request.getNeedTransport())
                .address(request.getAddress())
                .contactInfo(request.getContactInfo())
                .build();

        return offer;
    }
}
