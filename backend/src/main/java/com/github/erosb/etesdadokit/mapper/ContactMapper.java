package com.github.erosb.etesdadokit.mapper;

import com.github.erosb.etesdadokit.domain.ContactEntity;
import com.github.erosb.etesdadokit.feature.offer.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    Contact contactEntityToContact(ContactEntity contactEntity) {
        if (contactEntity == null) {
            return null;
        }

        Contact contact = Contact.builder()
                .nameOrCompany(contactEntity.getNameOrCompany())
                .email(contactEntity.getEmail())
                .phoneNumber(contactEntity.getPhoneNumber())
                .build();

        return contact;
    }

    ContactEntity contactToContactEntity(Contact contact) {
        if (contact == null) {
            return null;
        }

        ContactEntity contactEntity = ContactEntity.builder()
                .nameOrCompany(contact.getNameOrCompany())
                .email(contact.getEmail())
                .phoneNumber(contact.getPhoneNumber())
                .build();

        return contactEntity;
    }
}
