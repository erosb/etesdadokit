package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferEntity;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransportOfferService {

    TransportOfferResponse createTransportOffer(TransportOfferRequest request);

    List<TransportOfferResponse> findAll();

    TransportOfferResponse getTransportOfferByDate(LocalDate transportDate);

    List<TransportOfferResponse> listByDate(LocalDate day);

    TrasnsportOfferPagedList findAll(PageRequest pageRequest);
}
