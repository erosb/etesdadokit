package com.github.erosb.etesdadokit.services;

import com.github.erosb.etesdadokit.domain.FoodOfferEntity;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRequest;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferResponse;
import com.github.erosb.etesdadokit.mapper.FoodOfferMapper;
import com.github.erosb.etesdadokit.repository.FoodOfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodOfferServiceImpl implements FoodOfferService {

    private final FoodOfferMapper foodOfferMapper;
    private final FoodOfferRepository foodOfferRepository;

    public FoodOfferServiceImpl(FoodOfferMapper foodOfferMapper, FoodOfferRepository foodOfferRepository) {
        this.foodOfferMapper = foodOfferMapper;
        this.foodOfferRepository = foodOfferRepository;
    }

    @Override
    public List<FoodOfferResponse> getAllFoodOfferings() {
        return foodOfferRepository.findAll()
                .stream()
                .map(foodOfferMapper::foodOfferToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FoodOfferResponse createFoodOffer(FoodOfferRequest request) {

        return saveAndReturnResponse(foodOfferMapper.foodOfferRequestToFoodOffer(request));
    }

    private FoodOfferResponse saveAndReturnResponse(FoodOfferEntity foodOfferEntity) {
        FoodOfferEntity savedFoodOfferEntity = foodOfferRepository.save(foodOfferEntity);

        FoodOfferResponse response = foodOfferMapper.foodOfferToResponse(savedFoodOfferEntity);

        return response;
    }
}
