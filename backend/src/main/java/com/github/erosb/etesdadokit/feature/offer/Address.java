package com.github.erosb.etesdadokit.feature.offer;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Address {

    @NotEmpty
    private Integer zip;

    @NotEmpty
    private String city;

    @NotEmpty
    private String addressLineOne;

    @NotEmpty
    private String addressLineTwo;

}
