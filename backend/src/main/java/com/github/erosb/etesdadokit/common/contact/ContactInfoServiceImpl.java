package com.github.erosb.etesdadokit.common.contact;

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
