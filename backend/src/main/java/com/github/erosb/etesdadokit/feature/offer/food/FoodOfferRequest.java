package com.github.erosb.etesdadokit.feature.offer.food;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.github.erosb.etesdadokit.feature.offer.Address;
import com.github.erosb.etesdadokit.feature.offer.Contact;
import com.github.erosb.etesdadokit.feature.offer.TransportRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class FoodOfferRequest {

    @NotEmpty
    @ApiModelProperty("The offered food name")
    private String name;

    @Min(50)
    @NotNull
    @ApiModelProperty("The offered quantity, the minimum value is 50")
    private Integer quantity;

    @NotNull
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate transportDate;

    @NotBlank
    private String ingredients;

    @Valid
    private TransportRequest transportRequest;

    @NotNull
    @Valid
    private Address address;

    @NotNull
    @Valid
    private Contact contact;
}
