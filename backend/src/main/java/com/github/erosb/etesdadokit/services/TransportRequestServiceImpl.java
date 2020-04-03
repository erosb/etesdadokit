package com.github.erosb.etesdadokit.services;

import com.github.erosb.etesdadokit.domain.TransportRequestEntity;
import com.github.erosb.etesdadokit.repository.TransportRequestRepository;
import org.springframework.stereotype.Service;

@Service
public class TransportRequestServiceImpl implements TransportRequestService {

    private final TransportRequestRepository transportRequestRepository;

    public TransportRequestServiceImpl(TransportRequestRepository transportRequestRepository) {
        this.transportRequestRepository = transportRequestRepository;
    }

    @Override
    public TransportRequestEntity createTransportRequest(TransportRequestEntity transportRequestEntity) {
        return transportRequestRepository.save(transportRequestEntity);
    }
}
