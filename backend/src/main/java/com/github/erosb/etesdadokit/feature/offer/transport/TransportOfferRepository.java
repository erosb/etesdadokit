package com.github.erosb.etesdadokit.feature.offer.transport;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TransportOfferRepository extends JpaRepository<TransportOfferEntity, Long> {

    Optional<TransportOfferEntity> findByTransportDate(LocalDate date);
}
