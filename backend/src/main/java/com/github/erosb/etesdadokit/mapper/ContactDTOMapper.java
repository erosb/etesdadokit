package com.github.erosb.etesdadokit.mapper;

import com.github.erosb.etesdadokit.domain.ContactEntity;
import com.github.erosb.etesdadokit.feature.offer.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactDTOMapper implements DTOMapper<ContactEntity, Contact> {

    @Override
    public ContactEntity dtoToEntity(Contact contact) {
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

    @Override
    public Contact entityToDTO(ContactEntity entity) {
        if (entity == null) {
            return null;
        }

        Contact contact = Contact.builder()
                .nameOrCompany(entity.getNameOrCompany())
                .email(entity.getEmail())
                .phoneNumber(entity.getPhoneNumber())
                .build();

        return contact;
    }
}
