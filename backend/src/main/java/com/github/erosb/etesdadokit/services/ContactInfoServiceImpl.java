package com.github.erosb.etesdadokit.services;

import com.github.erosb.etesdadokit.domain.ContactEntity;
import com.github.erosb.etesdadokit.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    private final ContactRepository contactRepository;

    public ContactInfoServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactEntity createContactInfo(ContactEntity contactEntity) {
        return contactRepository.save(contactEntity);
    }
}
