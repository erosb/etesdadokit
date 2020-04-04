package com.github.erosb.etesdadokit.feature.offer.transport;

import java.util.List;

public interface TransportOfferService {

    TransportOfferResponse createTransportOffer(TransportOfferRequest request);

    List<TransportOfferResponse> findAll();
}
