package com.github.erosb.etesdadokit.feature.planner.tasks.materialSupply;

import com.github.erosb.etesdadokit.common.mapper.DTOMapper;
import com.github.erosb.etesdadokit.feature.planner.MaterialSupplyTask;
import com.github.erosb.etesdadokit.feature.planner.tasks.TransferTaskMapper;
import org.springframework.stereotype.Component;

@Component
public class MaterialSupplyTaskMapper implements DTOMapper<MaterialSupplyTaskEntity, MaterialSupplyTask> {

    private final TransferTaskMapper transferTaskMapper;

    public MaterialSupplyTaskMapper(TransferTaskMapper transferTaskMapper) {
        this.transferTaskMapper = transferTaskMapper;
    }

    @Override
    public MaterialSupplyTaskEntity dtoToEntity(MaterialSupplyTask dto) {
        return MaterialSupplyTaskEntity
                .builder()
                .acceptedMaterialOfferId(dto.getAcceptedMaterialOfferId())
                .transferTaskEmbeddable(transferTaskMapper.dtoToEntity(dto.getTransferTask()))
                .build();
    }

    @Override
    public MaterialSupplyTask entityToDTO(MaterialSupplyTaskEntity entity) {
        return MaterialSupplyTask
                .builder()
                .acceptedMaterialOfferId(entity.getAcceptedMaterialOfferId())
                .transferTask(transferTaskMapper.entityToDTO(entity.getTransferTaskEmbeddable()))
                .build();
    }
}
