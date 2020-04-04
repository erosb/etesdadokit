package com.github.erosb.etesdadokit.common.address;

import com.github.erosb.etesdadokit.common.mapper.DTOMapper;
import org.springframework.stereotype.Component;

@Component
public class AddressDTOMapper implements DTOMapper<AddressEntity, Address> {

    @Override
    public Address entityToDTO(AddressEntity addressEntity) {
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

    @Override
    public AddressEntity dtoToEntity(Address address) {
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
