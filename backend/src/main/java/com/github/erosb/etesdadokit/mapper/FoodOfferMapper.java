package com.github.erosb.etesdadokit.mapper;

import com.github.erosb.etesdadokit.domain.ContactInfo;
import com.github.erosb.etesdadokit.domain.FoodOffer;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferRequest;
import com.github.erosb.etesdadokit.feature.offer.food.FoodOfferResponse;
import com.github.erosb.etesdadokit.feature.offer.Address;
import com.github.erosb.etesdadokit.feature.offer.Contact;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodOfferMapper {

    public FoodOfferResponse foodOfferToResponse(FoodOffer foodOffer) {

        if (foodOffer == null) {
            return null;
        }

        FoodOfferResponse response = FoodOfferResponse.builder()
                .id(foodOffer.getId())
                .name(foodOffer.getName())
                .quantity(foodOffer.getPortion())
                .transportDate(foodOffer.getDeliveryDate())
                .ingredients(foodOffer.getNotes())
                .ableToTransport(foodOffer.getNeedTransport())
                // .address(foodOffer.getAddress()) // TODO see addressToAddressEntity
                // .contactInfo(foodOffer.getContactInfo()) // TODO see addressToAddressEntity
                .build();

        return response;
    }

    public FoodOffer foodOfferRequestToFoodOffer(FoodOfferRequest request) {
        if (request == null) {
            return null;
        }

        return FoodOffer.builder()
//                .id(request.getId())
                .name(request.getName())
                .portion(request.getQuantity())
                .deliveryDate(request.getTransportDate())
                .notes(request.getIngredients())
                .needTransport(request.getAbleToTransport())
                .address(addressToAddressEntity(request.getAddress()))
                .contactInfo(contactToContactEntity(request.getContacts()))
                .build();
    }

    // TODO rewrite mapping, take into account field names and structure
    public String addressToAddressEntity(Address address) {
        return address.toString();
    }

    // TODO rewrite mapping, take into account field names and structure
    public List<ContactInfo> contactToContactEntity(List<Contact> contacts) {

        return contacts.stream().map(contact -> {
            final ContactInfo contactInfo = new ContactInfo();
            contactInfo.setEmail(contact.getEmail());
            contactInfo.setName(contact.getNameOrCompany());
            contactInfo.setPhoneNumber(contact.getPhoneNumber());
            return contactInfo;
        }).collect(Collectors.toList());
    }
}
