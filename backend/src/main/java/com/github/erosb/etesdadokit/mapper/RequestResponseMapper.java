package com.github.erosb.etesdadokit.mapper;

public interface RequestResponseMapper<E, K, L>{

    L entityToResponse(E entity);

    E requestToEntity(K request);
}
