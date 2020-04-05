package com.github.erosb.etesdadokit.feature.offer.material;

import java.time.LocalDate;
import java.util.List;

public interface MaterialOfferService {

    MaterialOfferResponse createMaterialOffer(MaterialOfferRequest materialOfferRequest);

    List<MaterialOfferResponse> findAll();

    List<MaterialOfferResponse> listByDate(LocalDate day);
}
