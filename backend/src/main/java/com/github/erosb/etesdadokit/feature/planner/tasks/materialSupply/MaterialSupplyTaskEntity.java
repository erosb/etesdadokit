package com.github.erosb.etesdadokit.feature.planner.tasks.materialSupply;

import com.github.erosb.etesdadokit.feature.planner.tasks.TransferTaskEmbeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialSupplyTaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long acceptedMaterialOfferId;

    @Embedded
    private TransferTaskEmbeddable transferTaskEmbeddable;
}
