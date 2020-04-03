package com.github.erosb.etesdadokit.feature.offer;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class Contact {

    @NotEmpty
    private String nameOrCompany;

    @Email
    private String email;

    @NotEmpty
    private String phoneNumber;

}
