package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.domain.AddressEntity;
import com.github.erosb.etesdadokit.domain.ContactEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaterialOfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingredients;

    private Boolean availableAnytime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate offerDate;

    @OneToOne
    private AddressEntity address;

    @OneToOne
    private ContactEntity contact;

}
