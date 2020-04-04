package com.github.erosb.etesdadokit.feature.offer;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder(toBuilder = true)
public class Address {

    @Min(1000)
    @Max(9999)
    @NotNull
    private Integer zip;

    @NotEmpty
    private String city;

    @NotEmpty
    private String addressLineOne;

    private String addressLineTwo;

}
