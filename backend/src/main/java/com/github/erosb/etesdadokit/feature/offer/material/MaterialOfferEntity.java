package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.common.address.AddressEntity;
import com.github.erosb.etesdadokit.common.contact.ContactEntity;
import com.github.erosb.etesdadokit.common.transportRrequest.TransportRequestEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate offerDate;

    @OneToOne
    private TransportRequestEntity transportRequestEntity;

    @OneToOne
    private AddressEntity addressEntity;

    @OneToOne
    private ContactEntity contactEntity;

}
