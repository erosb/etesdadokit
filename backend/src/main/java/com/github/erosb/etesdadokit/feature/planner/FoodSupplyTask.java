package com.github.erosb.etesdadokit.feature.planner;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class FoodSupplyTask {

    private long acceptedFoodOfferId;

    @Min(50)
    private int portions;
}

