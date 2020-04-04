package com.github.erosb.etesdadokit.common.contact;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder(toBuilder = true)
public class Contact {

    @NotEmpty @ApiModelProperty(required = true)
    private String nameOrCompany;

    @Email
    @NotEmpty @ApiModelProperty(required = true)
    private String email;

    @NotEmpty @ApiModelProperty(required = true)
    private String phoneNumber;

}
