package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.common.contact.ContactDTOMapper;
import com.github.erosb.etesdadokit.common.mapper.RequestResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class TransportOfferMapper implements RequestResponseMapper<TransportOfferEntity, TransportOfferRequest, TransportOfferResponse> {


    private final ContactDTOMapper contactMapper;

    public TransportOfferMapper(ContactDTOMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

    @Override
    public TransportOfferResponse entityToResponse(TransportOfferEntity entity) {
        return TransportOfferResponse.builder()
                .id(entity.getId())
                .vehicleCapacity(entity.getVehicleCapacity())
                .refrigeratorCar(entity.getRefrigeratorCar())
                .transportDate(entity.getTransportDate())
                .cityOnly(entity.getCityOnly())
                .contact(contactMapper.entityToDTO(entity.getContact()))
                .firstAvailableHour(entity.getFirstAvailableHour())
                .build();
    }

    @Override
    public TransportOfferEntity requestToEntity(TransportOfferRequest request) {
        return TransportOfferEntity.builder()
                .vehicleCapacity(request.vehicleCapacity)
                .refrigeratorCar(request.refrigeratorCar)
                .transportDate(request.getOfferAvailableDate())
                .cityOnly(request.getCityOnly())
                .contact(contactMapper.dtoToEntity(request.getContact()))
                .firstAvailableHour(request.getFirstAvailableHour())
                .build();
    }
}
