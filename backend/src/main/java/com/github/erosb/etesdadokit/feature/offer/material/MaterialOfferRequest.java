package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.common.address.Address;
import com.github.erosb.etesdadokit.common.contact.Contact;
import com.github.erosb.etesdadokit.feature.offer.TransportRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class MaterialOfferRequest {

    @NotEmpty
    @ApiModelProperty(value = "List of the required ingredients", required = true)
    private String ingredients;

    // TODO az alapanyag biztosításának napja (bármely nap, vagy a következő 3 nap valamelyike)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate offerAvailableDate;

    private Boolean availableAnytime;

    private TransportRequest transportRequest;

    @NotNull
    @ApiModelProperty(value = "The offer related address", required = true)
    private Address address;

    @NotNull
    @ApiModelProperty(value = "The offer related contact", required = true)
    private Contact contact;
}
