package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.services.ContactInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportOfferServiceImpl implements TransportOfferService {

    private final TransportOfferRepository repository;
    private final TransportOfferMapper transportOfferMapper;
    private final ContactInfoService contactInfoService;

    public TransportOfferServiceImpl(TransportOfferRepository repository, TransportOfferMapper transportOfferMapper, ContactInfoService contactInfoService) {
        this.repository = repository;
        this.transportOfferMapper = transportOfferMapper;
        this.contactInfoService = contactInfoService;
    }

    @Override
    public TransportOfferResponse createTransportOffer(TransportOfferRequest request) {
        return saveEntityAndReturnResponse(transportOfferMapper.requestToEntity(request));
    }

    @Override
    public List<TransportOfferResponse> findAll() {
        return repository
                .findAll()
                .stream()
                .map(transportOfferMapper::entityToResponse)
                .collect(Collectors.toList());
    }

    private TransportOfferResponse saveEntityAndReturnResponse(TransportOfferEntity entity) {
        contactInfoService.createContactInfo(entity.getContact());

        TransportOfferEntity saved = repository.save(entity);
        TransportOfferResponse response = transportOfferMapper.entityToResponse(saved);

        return response;
    }
}
