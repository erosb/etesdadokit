package com.github.erosb.etesdadokit.feature.offer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;

@Data
public class TransportRequest {

    @DateTimeFormat(pattern = "HH:mm")
    @ApiModelProperty(value = "The time when the offerer request the pick up")
    private LocalTime timeToPickUp;

    @NotEmpty
    private String requestVehicleCapacity;

    @NotEmpty
    private Boolean requestRefrigeratorCar;

}
