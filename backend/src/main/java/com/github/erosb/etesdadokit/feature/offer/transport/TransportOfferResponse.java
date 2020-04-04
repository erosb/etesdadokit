package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.feature.offer.Contact;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
public class TransportOfferResponse {

    private Long id;

    public String vehicleCapacity;

    public Boolean refrigeratorCar;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate transportDate;

    private Integer firstAvailableHour;

    private Boolean cityOnly;

    private Contact contact;
}
