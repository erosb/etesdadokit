package com.github.erosb.etesdadokit.feature.offer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
@Builder
public class TransportRequest {

    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonFormat(pattern = "HH:mm")
    @DateTimeFormat(pattern = "HH:mm")
    @ApiModelProperty(value = "The time when the offerer request the pick up")
    private LocalTime timeToPickUp;

    @NotEmpty
    private String requestVehicleCapacity;

    @NotNull
    private Boolean requestRefrigeratorCar;

}
