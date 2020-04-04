package com.github.erosb.etesdadokit.feature.planner;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class DeliveryPlanResponse {

    private Long id;

    private LocalDate date;

    private FoodSupplyTask foodSupplyTask;

    private List<MaterialSupplyTask> materialSupplyTasks;

    private TransferTask transferTask;

}
