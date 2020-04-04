package com.github.erosb.etesdadokit.common.mapper;

public interface DTOMapper<E, D> {
    E dtoToEntity(D dto);

    D entityToDTO(E entity);

}
