package com.github.erosb.etesdadokit.mapper;

import com.github.erosb.etesdadokit.domain.FoodOffering;
import com.github.erosb.etesdadokit.model.FoodOfferingDTO;
import org.springframework.stereotype.Component;

@Component
public class FoodOfferingMapper {

    public FoodOfferingDTO foodOfferingToFoodOfferingDTO(FoodOffering foodOffering) {
        if (foodOffering == null) {
            return null;
        }
        FoodOfferingDTO dto = FoodOfferingDTO.builder()
                .id(foodOffering.getId())
                .name(foodOffering.getName())
                .portion(foodOffering.getPortion())
                .deliveryDate(foodOffering.getDeliveryDate())
                .notes(foodOffering.getNotes())
                .needTransport(foodOffering.getNeedTransport())
                .address(foodOffering.getAddress())
                .contactInfo(foodOffering.getContactInfo())
                .build();

        return dto;
    }

    public FoodOffering foodOfferingDTOtoFoodOffering(FoodOfferingDTO dto) {
        if (dto == null) {
            return null;
        }

        FoodOffering foodOffering = FoodOffering.builder()
                .id(dto.getId())
                .name(dto.getName())
                .portion(dto.getPortion())
                .deliveryDate(dto.getDeliveryDate())
                .notes(dto.getNotes())
                .needTransport(dto.getNeedTransport())
                .address(dto.getAddress())
                .contactInfo(dto.getContactInfo())
                .build();

        return foodOffering;
    }
}
