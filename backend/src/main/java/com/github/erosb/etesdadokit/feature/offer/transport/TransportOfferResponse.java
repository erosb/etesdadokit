package com.github.erosb.etesdadokit.feature.offer.transport;

public class TransportOfferResponse {

    public Boolean accepted;

    public Boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public String toString() {
        return "TransportOfferResponse{" +
                "accepted=" + accepted +
                '}';
    }
}
