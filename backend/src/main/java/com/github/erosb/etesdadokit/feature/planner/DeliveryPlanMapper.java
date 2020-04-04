package com.github.erosb.etesdadokit.feature.planner;

import com.github.erosb.etesdadokit.common.mapper.RequestResponseMapper;
import com.github.erosb.etesdadokit.feature.planner.tasks.FoodSupplyTaskMapper;
import com.github.erosb.etesdadokit.feature.planner.tasks.TransferTaskMapper;
import com.github.erosb.etesdadokit.feature.planner.tasks.materialSupply.MaterialSupplyTaskMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DeliveryPlanMapper implements RequestResponseMapper<DeliveryPlanEntity, DeliveryPlanRequest, DeliveryPlanResponse> {

    private final FoodSupplyTaskMapper foodSupplyTaskMapper;
    private final MaterialSupplyTaskMapper materialSupplyTaskMapper;
    private final TransferTaskMapper transferTaskMapper;

    public DeliveryPlanMapper(FoodSupplyTaskMapper foodSupplyTaskMapper,
                              MaterialSupplyTaskMapper materialSupplyTaskMapper,
                              TransferTaskMapper transferTaskMapper) {
        this.foodSupplyTaskMapper = foodSupplyTaskMapper;
        this.materialSupplyTaskMapper = materialSupplyTaskMapper;
        this.transferTaskMapper = transferTaskMapper;
    }

    @Override
    public DeliveryPlanResponse entityToResponse(DeliveryPlanEntity entity) {

        return DeliveryPlanResponse.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .foodSupplyTask(foodSupplyTaskMapper.entityToDTO(entity.getFoodSupplyTaskEmbeddable()))
                .materialSupplyTasks(entity
                        .getMaterialSupplyTaskEntity()
                        .stream()
                        .map(materialSupplyTaskMapper::entityToDTO).collect(Collectors.toList()))
                .transferTask(transferTaskMapper.entityToDTO(entity.getTransferTaskEmbeddable()))
                .build();
    }

    @Override
    public DeliveryPlanEntity requestToEntity(DeliveryPlanRequest request) {

        return DeliveryPlanEntity.builder()
                .date(request.getDate())
                .foodSupplyTaskEmbeddable(foodSupplyTaskMapper.dtoToEntity(request.getFoodSupplyTask()))
                .materialSupplyTaskEntity(request
                        .getMaterialSupplyTasks()
                        .stream()
                        .map(materialSupplyTaskMapper::dtoToEntity).collect(Collectors.toList()))
                .transferTaskEmbeddable(transferTaskMapper.dtoToEntity(request.getTransferTask()))
                .build();
    }
}
