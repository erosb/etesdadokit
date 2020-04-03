package com.github.erosb.etesdadokit.bootstrap;

import com.github.erosb.etesdadokit.domain.ContactInfo;
import com.github.erosb.etesdadokit.domain.FoodOffer;
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
        ContactInfo contactInfo = ContactInfo.builder()
                .email("test@test.com")
                .name("Janos")
                .phoneNumber("0630123456")
                .build();

        contactInfoRepository.save(contactInfo);

        FoodOffer offer = FoodOffer.builder()
                .id(1L)
                .name("Pizza")
                .portion(50)
                .deliveryDate(LocalDate.now())
                .address("Matyas 1")
                .contactInfo(Arrays.asList(contactInfo))
                .build();

        foodOfferRepository.save(offer);
    }
}
