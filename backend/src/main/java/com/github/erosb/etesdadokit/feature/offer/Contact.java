package com.github.erosb.etesdadokit.feature.offer;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class Contact {

    @NotEmpty
    private String nameOrCompany;

    @Email
    private String email;

    @NotEmpty
    private String phoneNumber;

}
