package com.github.erosb.etesdadokit.feature.offer.transport;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class TrasnsportOfferPagedList extends PageImpl<TransportOfferResponse> implements Serializable {

    public TrasnsportOfferPagedList(List<TransportOfferResponse> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public TrasnsportOfferPagedList(List<TransportOfferResponse> content) {
        super(content);
    }
}
