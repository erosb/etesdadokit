package com.github.erosb.etesdadokit.feature.offer.transport;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.github.erosb.etesdadokit.common.contact.Contact;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder(toBuilder = true)
public class TransportOfferRequest {

    @NotEmpty
    @ApiModelProperty(value = "The requested capacity of the vehicle or the vehicle type", required = true)
    public String vehicleCapacity;

    @NotNull
    @ApiModelProperty(value = "Should be a refrigerator car or not", required = true)
    public Boolean refrigeratorCar;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("The date when the offer is active")
    private LocalDate offerAvailableDate;

    @NotNull
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonFormat(pattern = "hh:mm")
    @DateTimeFormat(pattern = "hh:mm")
    @ApiModelProperty(value = "The time of the day from which the transport vehicle and driver is available", required = true)
    private LocalTime availableFrom;

    @NotNull
    @ApiModelProperty(value = "The offer is available only inside the city", required = true)
    private Boolean cityOnly;

    @NotNull
    @Valid
    @ApiModelProperty(value = "The offer related contact", required = true)
    private Contact contact;
}
