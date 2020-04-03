package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.feature.offer.Address;
import com.github.erosb.etesdadokit.feature.offer.Contact;
import com.github.erosb.etesdadokit.feature.offer.TransportRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
public class MaterialOfferRequest {

    @NotEmpty
    private String ingredients;

    // TODO az alapanyag biztosításának napja (bármely nap, vagy a következő 3 nap valamelyike)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date offerAvailableDate;

    @NotNull
    private Boolean ableToTransport;

    private TransportRequest transportRequest;

    @NotNull
    private Address address;

    @NotNull
    @Size(min=1)
    private List<Contact> contacts;
}
