package com.github.erosb.etesdadokit.feature.planner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FoodSupplyTask {

    private long acceptedFoodOfferId;

    @Min(50)
    private int portions;
}

