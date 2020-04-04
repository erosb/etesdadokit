package com.github.erosb.etesdadokit.feature.planner;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;

@Data
public class DeliveryPlanRequest {

    private LocalDate date;

    private FoodSupplyTask foodSupplyTask;

    private List<MaterialSupplyTask> materialSupplyTasks;

    @Nullable
    private TransferTask transferTask;

}
