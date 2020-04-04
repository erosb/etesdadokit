package com.github.erosb.etesdadokit.feature.planner;

import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRepository;
import com.github.erosb.etesdadokit.feature.offer.material.MaterialOfferRepository;
import com.github.erosb.etesdadokit.feature.offer.transport.TransportOfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPlanService {

    private final FoodOfferRepository foodOfferRepo;

    private final MaterialOfferRepository materialOfferRepo;

    private final TransportOfferRepository transportOfferRepo;

    private final DeliveryPlanRepository deliveryPlanRepository;
    private final DeliveryPlanMapper deliveryPlanMapper;


    public DeliveryPlanService(FoodOfferRepository foodOfferRepo,
                               MaterialOfferRepository materialOfferRepo,
                               TransportOfferRepository transportOfferRepo,
                               DeliveryPlanRepository deliveryPlanRepository,
                               DeliveryPlanMapper deliveryPlanMapper) {
        this.foodOfferRepo = foodOfferRepo;
        this.materialOfferRepo = materialOfferRepo;
        this.transportOfferRepo = transportOfferRepo;
        this.deliveryPlanRepository = deliveryPlanRepository;
        this.deliveryPlanMapper = deliveryPlanMapper;
    }

    DeliveryPlanResponse createDelivery(DeliveryPlanRequest request){

        return saveEntityAndReturnResponse(deliveryPlanMapper.requestToEntity(request));
    }

    private DeliveryPlanResponse saveEntityAndReturnResponse(DeliveryPlanEntity entity) {
//
//        if(!entity.getMaterialSupplyTaskEntity().isEmpty()){
//            ma
//        }

        DeliveryPlanEntity saved = deliveryPlanRepository.save(entity);
        return deliveryPlanMapper.entityToResponse(saved);

    }

    List<DeliveryPlanResponse> findAll(){
        return null;
    }

}
