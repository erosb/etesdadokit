package com.github.erosb.etesdadokit.domain;

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
public class FoodOfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer quantity;

    private LocalDate transportDate;

    private String ingredients;

    @OneToOne
    private TransportRequestEntity transportRequest;

    @OneToOne
    private ContactEntity contactEntity;

    @OneToOne
    private AddressEntity addressEntity;
}
