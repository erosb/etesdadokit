package com.github.erosb.etesdadokit.common.address;

import com.github.erosb.etesdadokit.feature.offer.NullOrNotBlank;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(required = true)
    private Integer zip;

    @NotEmpty
    @ApiModelProperty(required = true)
    private String city;

    @NotEmpty
    @ApiModelProperty(required = true)
    private String addressLineOne;

    @NullOrNotBlank
    private String addressLineTwo;

}
