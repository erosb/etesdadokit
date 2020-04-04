package com.github.erosb.etesdadokit.feature.planner;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TransferTask {

    private long acceptedTransferOfferId;

    private LocalTime departureTime;

}
