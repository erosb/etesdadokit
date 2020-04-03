package com.github.erosb.etesdadokit.mapper;

import com.github.erosb.etesdadokit.domain.FoodOfferEntity;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRequest;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferResponse;
import org.springframework.stereotype.Component;

@Component
public class FoodOfferMapper {

    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;
    private final TransportRequestMapper transportRequestMapper;

    public FoodOfferMapper(AddressMapper addressMapper, ContactMapper contactMapper, TransportRequestMapper transportRequestMapper) {
        this.addressMapper = addressMapper;
        this.contactMapper = contactMapper;
        this.transportRequestMapper = transportRequestMapper;
    }


    public FoodOfferResponse foodOfferToResponse(FoodOfferEntity foodOfferEntity) {

        if (foodOfferEntity == null) {
            return null;
        }

        FoodOfferResponse response = FoodOfferResponse.builder()
                .id(foodOfferEntity.getId())
                .name(foodOfferEntity.getName())
                .quantity(foodOfferEntity.getQuantity())
                .transportDate(foodOfferEntity.getTransportDate())
                .ingredients(foodOfferEntity.getIngredients())
                .address(addressMapper.entityToDTO(foodOfferEntity.getAddressEntity()))
                .contact(contactMapper.entityToDTO(foodOfferEntity.getContactEntity()))
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
                .quantity(request.getQuantity())
                .transportDate(request.getTransportDate())
                .ingredients(request.getIngredients())
                .transportRequest(transportRequestMapper.dtoToEntity(request.getTransportRequest()))
                .addressEntity(addressMapper.dtoToEntity(request.getAddress()))
                .contactEntity(contactMapper.dtoToEntity(request.getContact()))
                .build();
    }

}
