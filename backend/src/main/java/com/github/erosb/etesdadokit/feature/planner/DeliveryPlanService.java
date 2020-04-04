package com.github.erosb.etesdadokit.feature.planner;

import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRepository;
import com.github.erosb.etesdadokit.feature.offer.material.MaterialOfferRepository;
import com.github.erosb.etesdadokit.feature.offer.transport.TransportOfferRepository;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPlanService {

    private final FoodOfferRepository foodOfferRepo;

    private final MaterialOfferRepository materialOfferRepo;

    private final TransportOfferRepository transportOfferRepo;

    public DeliveryPlanService(FoodOfferRepository foodOfferRepo,
                               MaterialOfferRepository materialOfferRepo,
                               TransportOfferRepository transportOfferRepo) {
        this.foodOfferRepo = foodOfferRepo;
        this.materialOfferRepo = materialOfferRepo;
        this.transportOfferRepo = transportOfferRepo;
    }
}
