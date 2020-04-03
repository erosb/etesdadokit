package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.domain.ContactInfo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class FoodOfferResponse {

    private Long id;

    private String name;

    private Integer portion;

    private LocalDate deliveryDate;

    private String notes;

    private Boolean needTransport;

    private String address;

    private List<ContactInfo> contactInfo;
}
