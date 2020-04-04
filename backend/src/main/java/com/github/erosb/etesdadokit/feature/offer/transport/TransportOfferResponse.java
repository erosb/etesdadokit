package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.common.contact.Contact;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class TransportOfferResponse {

    private Long id;

    public String vehicleCapacity;

    public Boolean refrigeratorCar;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate transportDate;

    private LocalTime availableFrom;

    private Boolean cityOnly;

    private Contact contact;
}
