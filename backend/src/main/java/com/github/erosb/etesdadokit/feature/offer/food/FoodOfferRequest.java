package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.feature.offer.Address;
import com.github.erosb.etesdadokit.feature.offer.Contact;
import com.github.erosb.etesdadokit.feature.offer.TransportRequest;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class FoodOfferRequest {

    @NotEmpty
    private String name;

    @Min(50)
    private Integer quantity;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate transportDate;

    @NotEmpty
    private String ingredients;

    @NotNull
    private Boolean ableToTransport;

    private TransportRequest transportRequest;

    @NotNull
    private Address address;

    @NotNull
    @Size(min=1)
    private List<Contact> contacts;
}
