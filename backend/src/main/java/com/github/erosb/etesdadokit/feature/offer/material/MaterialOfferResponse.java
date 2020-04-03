package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.feature.shared.Address;
import com.github.erosb.etesdadokit.feature.shared.Contact;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class MaterialOfferResponse {

    private Long id;

    private String ingredients;

    // TODO az alapanyag biztosításának napja (bármely nap, vagy a következő 3 nap valamelyike)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date offerDate;

    private Boolean ableToTransport;

    private Address address;

    private List<Contact> contacts;

}
