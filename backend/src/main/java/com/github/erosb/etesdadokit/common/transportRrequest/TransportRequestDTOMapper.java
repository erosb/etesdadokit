package com.github.erosb.etesdadokit.common.transportRrequest;

import com.github.erosb.etesdadokit.feature.offer.TransportRequest;
import com.github.erosb.etesdadokit.common.mapper.DTOMapper;
import org.springframework.stereotype.Component;

@Component
public class TransportRequestDTOMapper implements DTOMapper<TransportRequestEntity, TransportRequest> {


    @Override
    public TransportRequestEntity dtoToEntity(TransportRequest dto) {
        if (dto == null) {
            return null;
        }

        TransportRequestEntity entity = TransportRequestEntity.builder()
                .timeToPickUp(dto.getTimeToPickUp())
                .requestVehicleCapacity(dto.getRequestVehicleCapacity())
                .requestRefrigeratorCar(dto.getRequestRefrigeratorCar())
                .build();

        return entity;
    }

    @Override
    public TransportRequest entityToDTO(TransportRequestEntity entity) {
        if (entity == null) {
            return null;
        }
        TransportRequest dto = TransportRequest.builder()
                .timeToPickUp(entity.getTimeToPickUp())
                .requestVehicleCapacity(entity.getRequestVehicleCapacity())
                .requestRefrigeratorCar(entity.getRequestRefrigeratorCar())
                .build();

        return dto;
    }
}
