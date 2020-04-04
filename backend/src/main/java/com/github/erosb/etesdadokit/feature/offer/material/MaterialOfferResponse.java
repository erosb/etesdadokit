package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.feature.offer.Address;
import com.github.erosb.etesdadokit.feature.offer.Contact;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class MaterialOfferResponse {

    private Long id;

    private String ingredients;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate offerDate;

    private Address address;

    private Contact contact;

}
