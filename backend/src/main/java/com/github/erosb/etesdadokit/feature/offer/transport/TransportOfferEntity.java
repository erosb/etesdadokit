package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.common.contact.ContactEntity;
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
public class TransportOfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleCapacity;

    private Boolean refrigeratorCar;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate transportDate;

    private Integer firstAvailableHour;

    private Boolean cityOnly;

    @OneToOne
    private ContactEntity contact;
}
