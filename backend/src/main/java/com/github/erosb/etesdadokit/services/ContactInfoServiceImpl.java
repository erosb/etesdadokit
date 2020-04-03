package com.github.erosb.etesdadokit.services;

import com.github.erosb.etesdadokit.domain.ContactInfo;
import com.github.erosb.etesdadokit.repository.ContactInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactInfoServiceImpl implements ContactInfoService {

    private  final ContactInfoRepository contactInfoRepository;

    public ContactInfoServiceImpl(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public ContactInfo createContactInfo(ContactInfo contactInfo) {
        return contactInfoRepository.save(contactInfo);
    }
}
