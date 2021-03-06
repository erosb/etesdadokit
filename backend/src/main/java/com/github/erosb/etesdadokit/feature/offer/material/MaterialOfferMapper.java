package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.common.address.AddressDTOMapper;
import com.github.erosb.etesdadokit.common.contact.ContactDTOMapper;
import com.github.erosb.etesdadokit.common.mapper.RequestResponseMapper;
import com.github.erosb.etesdadokit.common.transportRrequest.TransportRequestDTOMapper;
import org.springframework.stereotype.Component;

@Component
public class MaterialOfferMapper implements RequestResponseMapper<MaterialOfferEntity, MaterialOfferRequest, MaterialOfferResponse> {

    private final AddressDTOMapper addressMapper;
    private final ContactDTOMapper contactMapper;
    private final TransportRequestDTOMapper transportRequestMapper;

    public MaterialOfferMapper(AddressDTOMapper addressMapper,
                               ContactDTOMapper contactMapper,
                               TransportRequestDTOMapper transportRequestMapper) {
        this.addressMapper = addressMapper;
        this.contactMapper = contactMapper;
        this.transportRequestMapper = transportRequestMapper;
    }

    @Override
    public MaterialOfferResponse entityToResponse(MaterialOfferEntity entity) {
        if (entity == null)
            return null;

        return MaterialOfferResponse.builder()
                .id(entity.getId())
                .ingredients(entity.getIngredients())
                .offerDate(entity.getOfferDate())
                .address(addressMapper.entityToDTO(entity.getAddressEntity()))
                .contact(contactMapper.entityToDTO(entity.getContactEntity()))
                .build();
    }

    @Override
    public MaterialOfferEntity requestToEntity(MaterialOfferRequest request) {
        if (request == null)
            return null;

        return MaterialOfferEntity.builder()
                .ingredients(request.getIngredients())
                .offerDate(request.getOfferAvailableDate())
                .addressEntity(addressMapper.dtoToEntity(request.getAddress()))
                .contactEntity(contactMapper.dtoToEntity(request.getContact()))
                .transportRequestEntity(transportRequestMapper.dtoToEntity(request.getTransportRequest()))
                .build();
    }
}
