package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.feature.shared.Contact;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class TransportOfferResponse {

    private Long id;

    public String vehicleCapacity;

    public Boolean refrigeratorCar;

    //TODO fuvarozás napja (bármely nap, vagy a következő 3 nap valamelyike)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date transportDate;

    private Integer firstAvailableHour;

    private Boolean cityOnly;

    private List<Contact> contacts;
}
