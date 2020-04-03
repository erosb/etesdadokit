package com.github.erosb.etesdadokit.mapper;

import com.github.erosb.etesdadokit.domain.FoodOfferEntity;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRequest;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferResponse;
import org.springframework.stereotype.Component;

@Component
public class FoodOfferMapper {

    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;

    public FoodOfferMapper(AddressMapper addressMapper, ContactMapper contactMapper) {
        this.addressMapper = addressMapper;
        this.contactMapper = contactMapper;
    }


    public FoodOfferResponse foodOfferToResponse(FoodOfferEntity foodOfferEntity) {

        if (foodOfferEntity == null) {
            return null;
        }

        FoodOfferResponse response = FoodOfferResponse.builder()
                .id(foodOfferEntity.getId())
                .build();

        return response;
    }

    public FoodOfferEntity foodOfferRequestToFoodOffer(FoodOfferRequest request) {
        if (request == null) {
            return null;
        }

        return FoodOfferEntity.builder()
//                .id(request.getId())
                .name(request.getName())
                .portion(request.getQuantity())
                .deliveryDate(request.getTransportDate())
                .notes(request.getIngredients())
                .addressEntity(addressMapper.addressToAddressEntity(request.getAddress()))
                .contactEntity(contactMapper.contactToContactEntity(request.getContact()))
                .build();
    }

}
