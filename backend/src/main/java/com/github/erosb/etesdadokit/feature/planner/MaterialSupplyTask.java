package com.github.erosb.etesdadokit.feature.planner;

import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class MaterialSupplyTask {

    private long acceptedMaterialOfferId;

    @Nullable
    private TransferTask transferTask;

}
