package com.unifacisa.tap.bank.services.mapper;

import com.unifacisa.tap.bank.entities.Usuario;
import com.unifacisa.tap.bank.services.dto.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDto, Usuario> {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);


    @Override
    UsuarioDto toDto(Usuario entity);

    @Override
    Usuario toEntity(UsuarioDto dto);

}
