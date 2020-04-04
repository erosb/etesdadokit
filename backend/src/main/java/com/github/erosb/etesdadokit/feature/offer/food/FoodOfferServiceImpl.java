package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.services.AddressService;
import com.github.erosb.etesdadokit.services.ContactInfoService;
import com.github.erosb.etesdadokit.services.TransportRequestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
                .map(foodOfferMapper::foodOfferToResponse)
                .get();
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
        // TODO nem vagyok ebben biztos
        addressService.createAddress(foodOfferEntity.getAddressEntity());
        contactInfoService.createContactInfo(foodOfferEntity.getContactEntity());
        if (foodOfferEntity.getTransportRequest() != null)
            transportRequestService.createTransportRequest(foodOfferEntity.getTransportRequest());

        FoodOfferEntity savedFoodOfferEntity = foodOfferRepository.save(foodOfferEntity);


        FoodOfferResponse response = foodOfferMapper.foodOfferToResponse(savedFoodOfferEntity);

        return response;
    }
}
