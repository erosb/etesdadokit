package com.github.erosb.etesdadokit.feature.planner.tasks;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferTaskEmbeddable {

    private long acceptedTransferOfferId;

    private LocalTime departureTime;
}
