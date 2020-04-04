package com.github.erosb.etesdadokit.feature.planner.tasks;

import com.github.erosb.etesdadokit.common.mapper.DTOMapper;
import com.github.erosb.etesdadokit.feature.planner.FoodSupplyTask;
import org.springframework.stereotype.Component;

@Component
public class FoodSupplyTaskMapper implements DTOMapper<FoodSupplyTaskEmbeddable, FoodSupplyTask> {

    @Override
    public FoodSupplyTaskEmbeddable dtoToEntity(FoodSupplyTask dto) {
        return FoodSupplyTaskEmbeddable.builder()
                .acceptedFoodOfferId(dto.getAcceptedFoodOfferId())
                .portions(dto.getPortions())
                .build();
    }

    @Override
    public FoodSupplyTask entityToDTO(FoodSupplyTaskEmbeddable entity) {
        return FoodSupplyTask.builder()
                .acceptedFoodOfferId(entity.getAcceptedFoodOfferId())
                .portions(entity.getPortions())
                .build();
    }
}
