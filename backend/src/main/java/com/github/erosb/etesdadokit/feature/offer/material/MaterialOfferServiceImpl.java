package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.common.address.AddressService;
import com.github.erosb.etesdadokit.common.contact.ContactInfoService;
import com.github.erosb.etesdadokit.common.transportRrequest.TransportRequestService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class MaterialOfferServiceImpl implements MaterialOfferService {

    private final MaterialOfferMapper materialOfferMapper;
    private final MaterialOfferRepository repository;

    private final TransportRequestService transportRequestService;
    private final AddressService addressService;
    private final ContactInfoService contactInfoService;

    public MaterialOfferServiceImpl(MaterialOfferMapper materialOfferMapper, MaterialOfferRepository repository, TransportRequestService transportRequestService, AddressService addressService, ContactInfoService contactInfoService) {
        this.materialOfferMapper = materialOfferMapper;
        this.repository = repository;
        this.transportRequestService = transportRequestService;
        this.addressService = addressService;
        this.contactInfoService = contactInfoService;
    }

    @Override
    public MaterialOfferResponse createMaterialOffer(MaterialOfferRequest request) {
        return saveEntityAndReturnResponse(materialOfferMapper.requestToEntity(request));
    }

    @Override
    public List<MaterialOfferResponse> findAll() {
        return repository
                .findAll()
                .stream()
                .map(materialOfferMapper::entityToResponse)
                .collect(toList());
    }

    private MaterialOfferResponse saveEntityAndReturnResponse(MaterialOfferEntity entity){
        addressService.createAddress(entity.getAddressEntity());
        contactInfoService.createContactInfo(entity.getContactEntity());
        if (entity.getTransportRequestEntity() != null)
            transportRequestService.createTransportRequest(entity.getTransportRequestEntity());

        MaterialOfferEntity saved = repository.save(entity);

        MaterialOfferResponse response = materialOfferMapper.entityToResponse(saved);

        return response;
    }

    @Override
    public List<MaterialOfferResponse> listByDate(LocalDate day) {
        if (day == null) {
            return findAll();
        }
        return repository.findByOfferDate(day).stream().map(materialOfferMapper::entityToResponse).collect(toList());
    }

    @Override
    public MaterialOfferResponse findById(Long id) {
        return repository.findById(id)
                .map(materialOfferMapper::entityToResponse)
                .get();
    }

    @Override
    public MaterialOfferResponse getById(Long id) {
        return repository.findById(id)
                .map(materialOfferMapper::entityToResponse)
                .orElse(null);
    }
}
