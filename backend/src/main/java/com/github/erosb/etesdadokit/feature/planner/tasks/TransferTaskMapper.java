package com.github.erosb.etesdadokit.feature.planner.tasks;

import com.github.erosb.etesdadokit.common.mapper.DTOMapper;
import com.github.erosb.etesdadokit.feature.planner.TransferTask;
import org.springframework.stereotype.Component;

@Component
public class TransferTaskMapper implements DTOMapper<TransferTaskEmbeddable, TransferTask> {
    @Override
    public TransferTaskEmbeddable dtoToEntity(TransferTask dto) {
        if (dto == null) {
            return null;
        }
        return TransferTaskEmbeddable
                .builder()
                .acceptedTransferOfferId(dto.getAcceptedTransferOfferId())
                .departureTime(dto.getDepartureTime())
                .build();
    }

    @Override
    public TransferTask entityToDTO(TransferTaskEmbeddable entity) {
        if (entity == null) {
            return null;
        }
        return TransferTask
                .builder()
                .acceptedTransferOfferId(entity.getAcceptedTransferOfferId())
                .departureTime(entity.getDepartureTime())
                .build();
    }
}
