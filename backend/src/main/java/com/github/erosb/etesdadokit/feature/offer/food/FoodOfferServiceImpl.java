package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.common.address.AddressService;
import com.github.erosb.etesdadokit.common.contact.ContactInfoService;
import com.github.erosb.etesdadokit.common.transportRrequest.TransportRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FoodOfferServiceImpl implements FoodOfferService {

    private final FoodOfferMapper foodOfferMapper;
    private final FoodOfferRepository foodOfferRepository;

    private final TransportRequestService transportRequestService;
    private final AddressService addressService;
    private final ContactInfoService contactInfoService;

    public FoodOfferServiceImpl(FoodOfferMapper foodOfferMapper,
                                FoodOfferRepository foodOfferRepository,
                                TransportRequestService transportRequestService,
                                AddressService addressService,
                                ContactInfoService contactInfoService) {
        this.foodOfferMapper = foodOfferMapper;
        this.foodOfferRepository = foodOfferRepository;
        this.transportRequestService = transportRequestService;
        this.addressService = addressService;
        this.contactInfoService = contactInfoService;
    }

    @Override
    public FoodOfferResponse findById(Long id) {
        return foodOfferRepository.findById(id)
                .map(foodOfferMapper::entityToResponse)
                .get();
    }

    @Override
    public List<FoodOfferResponse> getAllFoodOfferings() {
        return foodOfferRepository.findAll()
                .stream()
                .map(foodOfferMapper::entityToResponse)
                .collect(toList());
    }

    @Override
    public FoodOfferResponse createFoodOffer(FoodOfferRequest request) {
        return saveEntityAndReturnResponse(foodOfferMapper.requestToEntity(request));
    }

    @Override
    public FoodOfferResponse getById(Long id) {
        return foodOfferRepository.findById(id)
                .map(foodOfferMapper::entityToResponse)
                .orElse(null);
    }

    private FoodOfferResponse saveEntityAndReturnResponse(FoodOfferEntity foodOfferEntity) {
        addressService.createAddress(foodOfferEntity.getAddressEntity());
        contactInfoService.createContactInfo(foodOfferEntity.getContactEntity());
        if (foodOfferEntity.getTransportRequestEntity() != null) {
            transportRequestService.createTransportRequest(foodOfferEntity.getTransportRequestEntity());
        }

        FoodOfferEntity savedFoodOfferEntity = foodOfferRepository.save(foodOfferEntity);

        return foodOfferMapper.entityToResponse(savedFoodOfferEntity);
    }

    @Override
    public List<FoodOfferResponse> listFoodOfferings(LocalDate day) {
        if (day == null) {
            return getAllFoodOfferings();
        } else {
            return foodOfferRepository.findByTransportDate(day).stream().map(foodOfferMapper::entityToResponse).collect(toList());
        }
    }

    @Override
    public List<FoodOfferResponse> getFoodOffersByIngredient(String ingredient) {
        return foodOfferRepository.findByIngredientsContainingIgnoreCase(ingredient).stream()
                .map(foodOfferMapper::entityToResponse).collect(toList());
    }
}
