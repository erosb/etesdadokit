package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.feature.shared.Address;
import com.github.erosb.etesdadokit.feature.shared.Contact;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class MaterialOfferRequest {

    @NotEmpty
    private String ingredients;

    // TODO az alapanyag biztosításának napja (bármely nap, vagy a következő 3 nap valamelyike)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date offerAvailableDate;

    @NotNull
    private Boolean ableToTransport;

    @NotNull
    private Address address;

    @NotNull
    private Contact contact;
}
