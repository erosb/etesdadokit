package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.common.address.AddressEntity;
import com.github.erosb.etesdadokit.common.contact.ContactEntity;
import com.github.erosb.etesdadokit.common.transportRrequest.TransportRequestEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    private TransportRequestEntity transportRequestEntity;

    @OneToOne
    private ContactEntity contactEntity;

    @OneToOne
    private AddressEntity addressEntity;
}
