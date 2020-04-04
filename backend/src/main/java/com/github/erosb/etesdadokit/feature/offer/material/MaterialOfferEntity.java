package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.domain.AddressEntity;
import com.github.erosb.etesdadokit.domain.ContactEntity;
import com.github.erosb.etesdadokit.feature.offer.Address;
import com.github.erosb.etesdadokit.feature.offer.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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
    private Date offerDate;

    @OneToOne
    private AddressEntity address;

    @OneToOne
    private ContactEntity contact;

}
