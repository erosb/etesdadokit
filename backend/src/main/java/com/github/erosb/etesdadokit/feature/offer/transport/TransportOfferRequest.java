package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.common.contact.Contact;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TransportOfferRequest {

    @NotEmpty
    @ApiModelProperty("The requested capacity of the vehicle or the vehicle type")
    public String vehicleCapacity;

    @NotNull
    @ApiModelProperty("Should be a refrigerator car or not")
    public Boolean refrigeratorCar;

    //TODO fuvarozás napja (bármely nap, vagy a következő 3 nap valamelyike)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty("The date when the offer is active")
    private LocalDate offerAvailableDate;

    @Max(24)
    @Min(0)
    @ApiModelProperty("First available hour")
    private Integer firstAvailableHour;

    @NotNull
    @ApiModelProperty("The offer is available only inside the city")
    private Boolean cityOnly;

    @NotNull
    @ApiModelProperty("The offer related contact")
    private Contact contact;
}
