package com.github.erosb.etesdadokit.mapper;

import com.github.erosb.etesdadokit.domain.AddressEntity;
import com.github.erosb.etesdadokit.feature.offer.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    Address addressEntityToAddress(AddressEntity addressEntity) {
        if (addressEntity == null) {
            return null;
        }
        Address address = Address.builder()
                .zip(addressEntity.getZip())
                .city(addressEntity.getCity())
                .addressLineOne(addressEntity.getAddressLineOne())
                .addressLineTwo(addressEntity.getAddressLineTwo())
                .build();

        return address;
    }

    AddressEntity addressToAddressEntity(Address address) {
        if (address == null) {
            return null;
        }
        AddressEntity entity = AddressEntity.builder()
                .zip(address.getZip())
                .city(address.getCity())
                .addressLineOne(address.getAddressLineOne())
                .addressLineTwo(address.getAddressLineTwo())
                .build();

        return entity;
    }
}
