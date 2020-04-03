package com.github.erosb.etesdadokit.bootstrap;

import com.github.erosb.etesdadokit.domain.AddressEntity;
import com.github.erosb.etesdadokit.domain.ContactEntity;
import com.github.erosb.etesdadokit.domain.FoodOfferEntity;
import com.github.erosb.etesdadokit.repository.AddressRepository;
import com.github.erosb.etesdadokit.repository.ContactRepository;
import com.github.erosb.etesdadokit.repository.FoodOfferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class Bootstrap implements CommandLineRunner {

    private final FoodOfferRepository foodOfferRepository;
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    public Bootstrap(FoodOfferRepository foodOfferRepository, ContactRepository contactRepository, AddressRepository addressRepository) {
        this.foodOfferRepository = foodOfferRepository;
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
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
                .city("Budapest")
                .zip(9045)
                .addressLineOne("Egyik utca")
                .addressLineTwo("16")
                .build();
        addressRepository.save(addressEntity);

        FoodOfferEntity offer = FoodOfferEntity.builder()
                .id(1L)
                .name("Pizza")
                .portion(50)
                .deliveryDate(LocalDate.now())
                .addressEntity(addressEntity)
                .contactEntity(contactEntity)
                .build();

        foodOfferRepository.save(offer);
    }
}
