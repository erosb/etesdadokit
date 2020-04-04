package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransportOfferService {

    TransportOfferResponse createTransportOffer(TransportOfferRequest request);

    List<TransportOfferResponse> findAll();

    TransportOfferResponse getTransportOfferByDate(LocalDate transportDate);

}
