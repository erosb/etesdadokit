package com.github.erosb.etesdadokit.services;

import com.github.erosb.etesdadokit.mapper.FoodOfferMapper;
import com.github.erosb.etesdadokit.model.FoodOfferDTO;
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
    public List<FoodOfferDTO> getAllFoodOfferings() {
        return foodOfferRepository.findAll()
                .stream()
                .map(foodOfferMapper::foodOfferToFoodOfferDTO)
                .collect(Collectors.toList());
    }
}
