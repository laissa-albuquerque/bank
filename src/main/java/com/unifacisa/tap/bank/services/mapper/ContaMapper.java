package com.unifacisa.tap.bank.services.mapper;

import com.unifacisa.tap.bank.entities.Conta;
import com.unifacisa.tap.bank.services.dto.ContaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContaMapper extends EntityMapper<ContaDto, Conta> {

    ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);

    @Override
    ContaDto toDto(Conta entity);

    @Override
    Conta toEntity(ContaDto dto);



}
