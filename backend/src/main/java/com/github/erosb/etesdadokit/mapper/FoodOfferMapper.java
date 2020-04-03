package com.github.erosb.etesdadokit.mapper;

import com.github.erosb.etesdadokit.domain.ContactEntity;
import com.github.erosb.etesdadokit.domain.FoodOfferEntity;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRequest;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferResponse;
import com.github.erosb.etesdadokit.feature.offer.Address;
import com.github.erosb.etesdadokit.feature.offer.Contact;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodOfferMapper {

    public FoodOfferResponse foodOfferToResponse(FoodOfferEntity foodOfferEntity) {

        if (foodOfferEntity == null) {
            return null;
        }

        FoodOfferResponse response = FoodOfferResponse.builder()
                .id(foodOfferEntity.getId())
                .name(foodOfferEntity.getName())
                .quantity(foodOfferEntity.getPortion())
                .transportDate(foodOfferEntity.getDeliveryDate())
                .ingredients(foodOfferEntity.getNotes())
                .ableToTransport(foodOfferEntity.getNeedTransport())
                // .address(foodOffer.getAddress()) // TODO see addressToAddressEntity
                // .contactInfo(foodOffer.getContactInfo()) // TODO see addressToAddressEntity
                .build();

        return response;
    }

    public FoodOfferEntity foodOfferRequestToFoodOffer(FoodOfferRequest request) {
        if (request == null) {
            return null;
        }

        return FoodOfferEntity.builder()
//                .id(request.getId())
                .name(request.getName())
                .portion(request.getQuantity())
                .deliveryDate(request.getTransportDate())
                .notes(request.getIngredients())
                .needTransport(request.getAbleToTransport())
                .address(addressToAddressEntity(request.getAddress()))
                .contactEntity(contactToContactEntity(request.getContacts()))
                .build();
    }

    // TODO rewrite mapping, take into account field names and structure
    public String addressToAddressEntity(Address address) {
        return address.toString();
    }

    // TODO rewrite mapping, take into account field names and structure
    public List<ContactEntity> contactToContactEntity(List<Contact> contacts) {

        return contacts.stream().map(contact -> {
            final ContactEntity contactEntity = new ContactEntity();
            contactEntity.setEmail(contact.getEmail());
            contactEntity.setName(contact.getNameOrCompany());
            contactEntity.setPhoneNumber(contact.getPhoneNumber());
            return contactEntity;
        }).collect(Collectors.toList());
    }
}
