package com.github.erosb.etesdadokit.feature.planner;

        import io.swagger.annotations.ApiModelProperty;
        import lombok.Data;
        import org.springframework.lang.Nullable;

        import javax.validation.constraints.NotNull;
        import java.time.LocalDate;
        import java.util.List;

@Data
public class DeliveryPlanRequest {

    @NotNull
    @ApiModelProperty(required = true)
    private LocalDate date;

    @NotNull
    @ApiModelProperty(required = true)
    private FoodSupplyTask foodSupplyTask;

    @NotNull
    @ApiModelProperty(required = true)
    private List<MaterialSupplyTask> materialSupplyTasks;

    @Nullable
    private TransferTask transferTask;

}
