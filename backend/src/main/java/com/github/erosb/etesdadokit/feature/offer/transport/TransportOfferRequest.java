package com.github.erosb.etesdadokit.feature.offer.transport;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransportOfferRequest {

    @NotEmpty
    public String capacity;

    @NotNull
    public Boolean refrigeratorCar;

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public boolean isAble() {
        return refrigeratorCar;
    }

    public void setAble(boolean able) {
        refrigeratorCar = able;
    }

    @Override
    public String toString() {
        return "TransportOfferRequest{" +
                "capacity='" + capacity + '\'' +
                ", isAble=" + refrigeratorCar +
                '}';
    }
}
