package com.github.erosb.etesdadokit.bootstrap;

import com.github.erosb.etesdadokit.common.address.AddressEntity;
import com.github.erosb.etesdadokit.common.address.AddressRepository;
import com.github.erosb.etesdadokit.common.contact.ContactEntity;
import com.github.erosb.etesdadokit.common.contact.ContactRepository;
import com.github.erosb.etesdadokit.common.transportRrequest.TransportRequestEntity;
import com.github.erosb.etesdadokit.common.transportRrequest.TransportRequestRepository;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferEntity;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRepository;
import com.github.erosb.etesdadokit.feature.offer.material.MaterialOfferEntity;
import com.github.erosb.etesdadokit.feature.offer.material.MaterialOfferRepository;
import com.github.erosb.etesdadokit.feature.offer.transport.TransportOfferEntity;
import com.github.erosb.etesdadokit.feature.offer.transport.TransportOfferRepository;
import com.github.erosb.etesdadokit.feature.planner.DeliveryPlanEntity;
import com.github.erosb.etesdadokit.feature.planner.DeliveryPlanRepository;
import com.github.erosb.etesdadokit.feature.planner.tasks.FoodSupplyTaskEmbeddable;
import com.github.erosb.etesdadokit.feature.planner.tasks.TransferTaskEmbeddable;
import com.github.erosb.etesdadokit.feature.planner.tasks.materialSupply.MaterialSupplyTaskEntity;
import com.github.erosb.etesdadokit.feature.planner.tasks.materialSupply.MaterialSupplyTaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

//@Component
public class Bootstrap implements CommandLineRunner {

    private final FoodOfferRepository foodOfferRepository;
    private final MaterialOfferRepository materialOfferRepository;
    private final DeliveryPlanRepository deliveryPlanRepository;

    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;
    private final TransportRequestRepository transportRequestRepository;
    private final TransportOfferRepository transportOfferRepository;
    private final MaterialSupplyTaskRepository materialSupplyTaskRepository;

    public Bootstrap(FoodOfferRepository foodOfferRepository,
                     MaterialOfferRepository materialOfferRepository,
                     DeliveryPlanRepository deliveryPlanRepository, ContactRepository contactRepository,
                     AddressRepository addressRepository,
                     TransportRequestRepository transportRequestRepository, TransportOfferRepository transportOfferRepository, MaterialSupplyTaskRepository materialSupplyTaskRepository) {
        this.foodOfferRepository = foodOfferRepository;
        this.materialOfferRepository = materialOfferRepository;
        this.deliveryPlanRepository = deliveryPlanRepository;
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
        this.transportRequestRepository = transportRequestRepository;
        this.transportOfferRepository = transportOfferRepository;
        this.materialSupplyTaskRepository = materialSupplyTaskRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadAddress();
        loadContact();
        loadTransportRequest();

        loadFoodOffers();
        loadMaterialOffers();
        loadTransportOffers();

        loadMaterialSupplyTasks();
        loadDeliveryPlan();
    }

    ContactEntity contactEntity;
    AddressEntity addressEntity;
    TransportRequestEntity transportRequestEntity;
    MaterialSupplyTaskEntity materialSupplyTaskEntity;

    private void loadAddress() {
        addressEntity = AddressEntity.builder()
                .id(1L)
                .city("Budapest")
                .zip(9045)
                .addressLineOne("Egyik utca")
                .addressLineTwo("16")
                .build();
        addressRepository.save(addressEntity);
    }

    private void loadContact() {
        contactEntity = ContactEntity.builder()
                .email("test@test.com")
                .nameOrCompany("Janos")
                .phoneNumber("0630123456")
                .build();

        contactRepository.save(contactEntity);
    }

    private void loadTransportRequest() {
        transportRequestEntity = TransportRequestEntity.builder()
                .id(1L)
                .requestRefrigeratorCar(true)
                .requestVehicleCapacity("normal")
                .timeToPickUp(LocalTime.NOON)
                .build();

        transportRequestRepository.save(transportRequestEntity);
    }

    private void loadFoodOffers() {
        FoodOfferEntity offer = FoodOfferEntity.builder()
                .id(1L)
                .name("Pizza")
                .quantity(50)
                .transportDate(LocalDate.now())
                .ingredients("food")
                .transportRequestEntity(transportRequestEntity)
                .contactEntity(contactEntity)
                .addressEntity(addressEntity)
                .build();

        foodOfferRepository.save(offer);
    }

    private void loadMaterialOffers() {
        materialOfferRepository.save(
                MaterialOfferEntity.builder()
                        .id(1L)
                        .ingredients("raw material ingredient")
                        .offerDate(LocalDate.now())
                        .transportRequestEntity(transportRequestEntity)
                        .addressEntity(addressEntity)
                        .contactEntity(contactEntity)
                        .build());
    }

    private void loadTransportOffers() {
        transportOfferRepository.save(
                TransportOfferEntity.builder()
                        .id(1L)
                        .vehicleCapacity("normal")
                        .refrigeratorCar(true)
                        .transportDate(LocalDate.now())
                        .availableFrom(LocalTime.NOON)
                        .cityOnly(false)
                        .contact(contactEntity)
                        .build()
        );
    }

    private void loadMaterialSupplyTasks() {
        materialSupplyTaskEntity = MaterialSupplyTaskEntity.builder()
                .id(1L)
                .acceptedMaterialOfferId(1L)
                .transferTaskEmbeddable(TransferTaskEmbeddable.builder()
                        .departureTime(LocalTime.now())
                        .acceptedTransferOfferId(1L)
                        .build())
                .build();
        materialSupplyTaskRepository.save(materialSupplyTaskEntity);
    }

    private void loadDeliveryPlan() {
        deliveryPlanRepository.save(
                DeliveryPlanEntity.builder()
                        .id(1L)
                        .transferTaskEmbeddable(TransferTaskEmbeddable.builder()
                                .departureTime(LocalTime.now())
                                .acceptedTransferOfferId(1L)
                                .build())
                        .materialSupplyTaskEntity(Arrays.asList(materialSupplyTaskEntity))
                        .foodSupplyTaskEmbeddable(FoodSupplyTaskEmbeddable.builder()
                                .portions(51)
                                .acceptedFoodOfferId(1L)
                                .build())
                        .date(LocalDate.now())
                        .build());
    }
}
