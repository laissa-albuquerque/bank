package com.unifacisa.tap.bank.services.mapper;

public interface EntityMapper<D, E> {

    D toDto(E entity);

    E toEntity(D dto);

}
