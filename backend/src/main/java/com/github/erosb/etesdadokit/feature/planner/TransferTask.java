package com.github.erosb.etesdadokit.feature.planner;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TransferTask {

    private int contactInfoId;

    private LocalTime departureTime;

    private int sourceAddressId;

    private int destinationAddressId;

}
