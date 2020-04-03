package com.github.erosb.etesdadokit.bootstrap;

import com.github.erosb.etesdadokit.domain.ContactEntity;
import com.github.erosb.etesdadokit.domain.FoodOfferEntity;
import com.github.erosb.etesdadokit.repository.ContactInfoRepository;
import com.github.erosb.etesdadokit.repository.FoodOfferRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class Bootstrap implements CommandLineRunner {

    private final FoodOfferRepository foodOfferRepository;
    private final ContactInfoRepository contactInfoRepository;

    public Bootstrap(FoodOfferRepository foodOfferRepository, ContactInfoRepository contactInfoRepository) {
        this.foodOfferRepository = foodOfferRepository;
        this.contactInfoRepository = contactInfoRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadFoodOffers();

    }

    private void loadFoodOffers() {
        ContactEntity contactEntity = ContactEntity.builder()
                .email("test@test.com")
                .name("Janos")
                .phoneNumber("0630123456")
                .build();

        contactInfoRepository.save(contactEntity);

        FoodOfferEntity offer = FoodOfferEntity.builder()
                .id(1L)
                .name("Pizza")
                .portion(50)
                .deliveryDate(LocalDate.now())
                .address("Matyas 1")
                .contactEntity(Arrays.asList(contactEntity))
                .build();

        foodOfferRepository.save(offer);
    }
}
