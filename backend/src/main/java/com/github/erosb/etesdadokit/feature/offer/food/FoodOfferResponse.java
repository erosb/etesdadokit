package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.feature.offer.Address;
import com.github.erosb.etesdadokit.feature.offer.Contact;
import com.github.erosb.etesdadokit.feature.offer.TransportRequest;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class FoodOfferResponse {

    private Long id;

    private String name;

    private Integer quantity;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate transportDate;

    private String ingredients;

    private Address address;

    private Contact contact;

    private TransportRequest transportRequest;
}
