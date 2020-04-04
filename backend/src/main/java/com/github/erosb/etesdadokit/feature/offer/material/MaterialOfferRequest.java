package com.github.erosb.etesdadokit.feature.offer.material;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.github.erosb.etesdadokit.common.address.Address;
import com.github.erosb.etesdadokit.common.contact.Contact;
import com.github.erosb.etesdadokit.feature.offer.TransportRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class MaterialOfferRequest {

    @NotEmpty
    @ApiModelProperty(value = "List of the required ingredients", required = true)
    private String ingredients;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("The date when the offer is active")
    private LocalDate offerAvailableDate;

    @Valid
    private TransportRequest transportRequest;

    @NotNull
    @Valid
    @ApiModelProperty(value = "The offer related address", required = true)
    private Address address;

    @NotNull
    @Valid
    @ApiModelProperty(value = "The offer related contact", required = true)
    private Contact contact;
}
