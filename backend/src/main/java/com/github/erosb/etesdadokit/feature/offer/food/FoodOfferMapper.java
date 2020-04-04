package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.mapper.AddressDTOMapper;
import com.github.erosb.etesdadokit.mapper.ContactDTOMapper;
import com.github.erosb.etesdadokit.mapper.RequestResponseMapper;
import com.github.erosb.etesdadokit.mapper.TransportRequestDTOMapper;
import org.springframework.stereotype.Component;

@Component
public class FoodOfferMapper implements RequestResponseMapper<FoodOfferEntity, FoodOfferRequest, FoodOfferResponse> {

    private final AddressDTOMapper addressMapper;
    private final ContactDTOMapper contactMapper;
    private final TransportRequestDTOMapper transportRequestMapper;

    public FoodOfferMapper(AddressDTOMapper addressMapper, ContactDTOMapper contactMapper, TransportRequestDTOMapper transportRequestMapper) {
        this.addressMapper = addressMapper;
        this.contactMapper = contactMapper;
        this.transportRequestMapper = transportRequestMapper;
    }

    @Override
    public FoodOfferResponse entityToResponse(FoodOfferEntity entity) {

        if (entity == null) {
            return null;
        }

        return FoodOfferResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .quantity(entity.getQuantity())
                .transportDate(entity.getTransportDate())
                .ingredients(entity.getIngredients())
                .address(addressMapper.entityToDTO(entity.getAddressEntity()))
                .contact(contactMapper.entityToDTO(entity.getContactEntity()))
                .transportRequest(transportRequestMapper.entityToDTO(entity.getTransportRequestEntity()))
                .build();
    }

    @Override
    public FoodOfferEntity requestToEntity(FoodOfferRequest request) {
        if (request == null) {
            return null;
        }

        return FoodOfferEntity.builder()
//                .id(request.getId())
                .name(request.getName())
                .quantity(request.getQuantity())
                .transportDate(request.getTransportDate())
                .ingredients(request.getIngredients())
                .transportRequestEntity(transportRequestMapper.dtoToEntity(request.getTransportRequest()))
                .addressEntity(addressMapper.dtoToEntity(request.getAddress()))
                .contactEntity(contactMapper.dtoToEntity(request.getContact()))
                .build();
    }
}
