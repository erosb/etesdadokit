package com.github.erosb.etesdadokit.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer portion;

    private LocalDate deliveryDate;

    private String notes;

    private Boolean needTransport;

    private String address;

    @OneToMany
    private List<ContactInfo> contactInfo;
}
