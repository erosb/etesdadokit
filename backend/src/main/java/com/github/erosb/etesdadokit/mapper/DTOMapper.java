package com.github.erosb.etesdadokit.mapper;

public interface DTOMapper<E, D> {
    E dtoToEntity(D dto);

    D entityToDTO(E entity);

}
