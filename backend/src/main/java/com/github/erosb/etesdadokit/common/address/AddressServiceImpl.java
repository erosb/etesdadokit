package com.github.erosb.etesdadokit.common.address;

import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressEntity createAddress(AddressEntity addressEntity) {
        return addressRepository.save(addressEntity);
    }
}
