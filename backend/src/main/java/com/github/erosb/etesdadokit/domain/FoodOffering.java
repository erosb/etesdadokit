package com.github.erosb.etesdadokit.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
public class FoodOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer portion;

    @Temporal(TemporalType.DATE)
    private Date deliveryDate;

    private String notes;

    private Boolean needTransport;

    private String address;

    @OneToMany
    private List<ContactInfo> contactInfo;
}
