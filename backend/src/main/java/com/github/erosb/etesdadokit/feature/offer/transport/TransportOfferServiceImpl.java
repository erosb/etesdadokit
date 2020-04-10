package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.common.contact.ContactInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
                .collect(toList());
    }

    @Override
    public TransportOfferResponse getTransportOfferByDate(LocalDate transportDate) {
        return repository
                .findByTransportDate(transportDate)
                .map(transportOfferMapper::entityToResponse)
                .orElse(null);
    }

    @Override
    public List<TransportOfferResponse> listByDate(LocalDate day) {
        if (day == null) {
            return findAll();
        } else {
            return repository.getByTransportDate(day).stream().map(transportOfferMapper::entityToResponse).collect(toList());
        }
    }

    @Override
    public TrasnsportOfferPagedList findAll(PageRequest pageRequest) {
        Page<TransportOfferEntity> page;
        page = repository.findAll(pageRequest);

        return new TrasnsportOfferPagedList(page
                .getContent()
                .stream()
                .map(transportOfferMapper::entityToResponse)
                .collect(Collectors.toList()),
                PageRequest
                        .of(page.getPageable().getPageNumber(),
                                page.getPageable().getPageSize()),
                page.getTotalElements());
    }
    private TransportOfferResponse saveEntityAndReturnResponse(TransportOfferEntity entity) {
        contactInfoService.createContactInfo(entity.getContact());

        TransportOfferEntity saved = repository.save(entity);
        TransportOfferResponse response = transportOfferMapper.entityToResponse(saved);

        return response;
    }
}
