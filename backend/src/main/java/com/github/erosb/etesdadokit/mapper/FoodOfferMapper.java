package com.github.erosb.etesdadokit.mapper;

import com.github.erosb.etesdadokit.domain.FoodOffer;
import com.github.erosb.etesdadokit.model.FoodOfferDTO;
import org.springframework.stereotype.Component;

@Component
public class FoodOfferMapper {

    public FoodOfferDTO foodOfferToFoodOfferDTO(FoodOffer foodOffer) {
        if (foodOffer == null) {
            return null;
        }
        FoodOfferDTO dto = FoodOfferDTO.builder()
                .id(foodOffer.getId())
                .name(foodOffer.getName())
                .portion(foodOffer.getPortion())
                .deliveryDate(foodOffer.getDeliveryDate())
                .notes(foodOffer.getNotes())
                .needTransport(foodOffer.getNeedTransport())
                .address(foodOffer.getAddress())
                .contactInfo(foodOffer.getContactInfo())
                .build();

        return dto;
    }

    public FoodOffer foodOfferDTOtoFoodOffer(FoodOfferDTO dto) {
        if (dto == null) {
            return null;
        }

        FoodOffer foodOffer = FoodOffer.builder()
                .id(dto.getId())
                .name(dto.getName())
                .portion(dto.getPortion())
                .deliveryDate(dto.getDeliveryDate())
                .notes(dto.getNotes())
                .needTransport(dto.getNeedTransport())
                .address(dto.getAddress())
                .contactInfo(dto.getContactInfo())
                .build();

        return foodOffer;
    }
}
