package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.feature.offer.Contact;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TransportOfferRequest {

    @NotEmpty
    public String vehicleCapacity;

    @NotNull
    public Boolean refrigeratorCar;

    //TODO fuvarozás napja (bármely nap, vagy a következő 3 nap valamelyike)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date offerAvailableDate;

    @Max(24)
    @Min(0)
    private Integer firstAvailableHour;

    @NotNull
    private Boolean cityOnly;

    @NotNull
    private Contact contact;
}
