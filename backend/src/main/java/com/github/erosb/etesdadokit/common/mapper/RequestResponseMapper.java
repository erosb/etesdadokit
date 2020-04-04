package com.github.erosb.etesdadokit.common.mapper;

public interface RequestResponseMapper<E, K, L>{

    L entityToResponse(E entity);

    E requestToEntity(K request);
}
