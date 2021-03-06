package com.github.erosb.etesdadokit.feature.planner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferTask {

    private long acceptedTransferOfferId;

    private LocalTime departureTime;

}
