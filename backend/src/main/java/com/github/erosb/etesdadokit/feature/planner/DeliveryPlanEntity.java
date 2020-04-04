package com.github.erosb.etesdadokit.feature.planner;

import com.github.erosb.etesdadokit.feature.planner.tasks.materialSupply.MaterialSupplyTaskEntity;
import com.github.erosb.etesdadokit.feature.planner.tasks.TransferTaskEmbeddable;
import com.github.erosb.etesdadokit.feature.planner.tasks.FoodSupplyTaskEmbeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryPlanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @Embedded
    private FoodSupplyTaskEmbeddable foodSupplyTaskEmbeddable;

    @OneToMany
    private List<MaterialSupplyTaskEntity> materialSupplyTaskEntity;

    @Embedded
    private TransferTaskEmbeddable transferTaskEmbeddable;
}
