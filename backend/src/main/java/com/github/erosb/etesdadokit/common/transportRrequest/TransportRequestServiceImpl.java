package com.github.erosb.etesdadokit.common.transportRrequest;

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
