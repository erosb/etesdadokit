package com.github.erosb.etesdadokit.feature.offer;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class TransportRequest {

    @Max(24)
    @Min(0)
    private Integer earliestHour;

    @Max(60)
    @Min(0)
    private Integer earliestMin;

    @NotEmpty
    private String requestVehicleCapacity;

    @NotEmpty
    private Boolean requestRefrigeratorCar;

}
