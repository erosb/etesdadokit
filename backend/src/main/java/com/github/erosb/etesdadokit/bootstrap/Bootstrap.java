package com.github.erosb.etesdadokit.bootstrap;

import com.github.erosb.etesdadokit.domain.AddressEntity;
import com.github.erosb.etesdadokit.domain.ContactEntity;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferEntity;
import com.github.erosb.etesdadokit.domain.TransportRequestEntity;
import com.github.erosb.etesdadokit.repository.AddressRepository;
import com.github.erosb.etesdadokit.repository.ContactRepository;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRepository;
import com.github.erosb.etesdadokit.repository.TransportRequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class Bootstrap implements CommandLineRunner {

    private final FoodOfferRepository foodOfferRepository;
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;
    private final TransportRequestRepository transportRequestRepository;

    public Bootstrap(FoodOfferRepository foodOfferRepository, ContactRepository contactRepository, AddressRepository addressRepository, TransportRequestRepository transportRequestRepository) {
        this.foodOfferRepository = foodOfferRepository;
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
        this.transportRequestRepository = transportRequestRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadFoodOffers();

    }

    private void loadFoodOffers() {
        ContactEntity contactEntity = ContactEntity.builder()
                .email("test@test.com")
                .nameOrCompany("Janos")
                .phoneNumber("0630123456")
                .build();

        contactRepository.save(contactEntity);

        AddressEntity addressEntity = AddressEntity.builder()
                .id(1L)
                .city("Budapest")
                .zip(9045)
                .addressLineOne("Egyik utca")
                .addressLineTwo("16")
                .build();
        addressRepository.save(addressEntity);

        TransportRequestEntity transportRequestEntity = TransportRequestEntity.builder()
                .id(1L)
                .requestRefrigeratorCar(true)
                .requestVehicleCapacity("normal")
                .timeToPickUp(LocalTime.NOON)
                .build();

        transportRequestRepository.save(transportRequestEntity);

        FoodOfferEntity offer = FoodOfferEntity.builder()
                .id(1L)
                .name("Pizza")
                .quantity(50)
                .transportDate(LocalDate.now())
                .ingredients("food")
                .transportRequest(transportRequestEntity)
                .contactEntity(contactEntity)
                .addressEntity(addressEntity)
                .build();

        foodOfferRepository.save(offer);
    }
}
