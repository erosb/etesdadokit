package com.github.erosb.etesdadokit.feature.planner.tasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FoodSupplyTaskEmbeddable {

    private Long acceptedFoodOfferId;

    private Integer portions;
}
