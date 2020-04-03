package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.feature.shared.Address;
import com.github.erosb.etesdadokit.feature.shared.Contact;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    @NotNull
    private Address address;

    @NotNull
    private Contact contact;
}
