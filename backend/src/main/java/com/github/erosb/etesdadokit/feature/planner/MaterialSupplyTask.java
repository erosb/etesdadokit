package com.github.erosb.etesdadokit.feature.planner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaterialSupplyTask {

    private long acceptedMaterialOfferId;

    @Nullable
    private TransferTask transferTask;

}
