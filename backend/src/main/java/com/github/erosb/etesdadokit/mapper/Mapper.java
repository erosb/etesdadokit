package com.github.erosb.etesdadokit.mapper;

public interface Mapper<E, D> {
    E dtoToEntity(D dto);

    D entityToDTO(E entity);

}
