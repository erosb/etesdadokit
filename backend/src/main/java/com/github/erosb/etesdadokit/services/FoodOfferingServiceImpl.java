package com.github.erosb.etesdadokit.services;

import com.github.erosb.etesdadokit.mapper.FoodOfferingMapper;
import com.github.erosb.etesdadokit.model.FoodOfferingDTO;
import com.github.erosb.etesdadokit.repository.FoodOfferingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodOfferingServiceImpl implements FoodOfferingService {

    private final FoodOfferingMapper foodOfferingMapper;
    private final FoodOfferingRepository foodOfferingRepository;

    public FoodOfferingServiceImpl(FoodOfferingMapper foodOfferingMapper, FoodOfferingRepository foodOfferingRepository) {
        this.foodOfferingMapper = foodOfferingMapper;
        this.foodOfferingRepository = foodOfferingRepository;
    }

    @Override
    public List<FoodOfferingDTO> getAllFoodOfferings() {
        return foodOfferingRepository.findAll()
                .stream()
                .map(foodOfferingMapper::foodOfferingToFoodOfferingDTO)
                .collect(Collectors.toList());
    }
}
