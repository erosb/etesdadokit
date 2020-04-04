package com.github.erosb.etesdadokit.feature.planner;

import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRepository;
import com.github.erosb.etesdadokit.feature.offer.transport.TransportOfferRepository;
import com.github.erosb.etesdadokit.feature.planner.tasks.materialSupply.MaterialSupplyTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryPlanService {

    private final FoodOfferRepository foodOfferRepo;

    private final MaterialSupplyTaskRepository materialSupplyTaskRepository;

    private final TransportOfferRepository transportOfferRepo;

    private final DeliveryPlanRepository deliveryPlanRepository;
    private final DeliveryPlanMapper deliveryPlanMapper;


    public DeliveryPlanService(FoodOfferRepository foodOfferRepo,
                               MaterialSupplyTaskRepository materialSupplyTaskRepository, TransportOfferRepository transportOfferRepo,
                               DeliveryPlanRepository deliveryPlanRepository,
                               DeliveryPlanMapper deliveryPlanMapper) {
        this.foodOfferRepo = foodOfferRepo;
        this.materialSupplyTaskRepository = materialSupplyTaskRepository;
        this.transportOfferRepo = transportOfferRepo;
        this.deliveryPlanRepository = deliveryPlanRepository;
        this.deliveryPlanMapper = deliveryPlanMapper;
    }

    DeliveryPlanResponse createDelivery(DeliveryPlanRequest request) {

        return saveEntityAndReturnResponse(deliveryPlanMapper.requestToEntity(request));
    }

    private DeliveryPlanResponse saveEntityAndReturnResponse(DeliveryPlanEntity entity) {
        if (entity.getMaterialSupplyTaskEntity() != null && !entity.getMaterialSupplyTaskEntity().isEmpty())
            materialSupplyTaskRepository.saveAll(entity.getMaterialSupplyTaskEntity());
        DeliveryPlanEntity saved = deliveryPlanRepository.save(entity);

        return deliveryPlanMapper.entityToResponse(saved);

    }

    List<DeliveryPlanResponse> findAll() {
        return deliveryPlanRepository.findAll()
                .stream()
                .map(deliveryPlanMapper::entityToResponse)
                .collect(Collectors.toList());
    }

}
