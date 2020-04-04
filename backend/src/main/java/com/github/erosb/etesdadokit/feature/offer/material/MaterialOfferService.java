package com.github.erosb.etesdadokit.feature.offer.material;

import java.util.List;

public interface MaterialOfferService {

    MaterialOfferResponse createMaterialOffer(MaterialOfferRequest materialOfferRequest);

    List<MaterialOfferResponse> findAll();
}
