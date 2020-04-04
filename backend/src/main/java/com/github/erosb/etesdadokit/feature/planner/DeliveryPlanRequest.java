package com.github.erosb.etesdadokit.feature.planner;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class DeliveryPlanRequest {

    @NotNull
    private LocalDate date;

    @NotNull
    private FoodSupplyTask foodSupplyTask;

    @NotNull
    private List<MaterialSupplyTask> materialSupplyTasks;

    @Nullable
    private TransferTask transferTask;

}
